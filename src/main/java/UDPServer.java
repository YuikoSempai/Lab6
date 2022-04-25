//Должен быть реализован на датаграммах

import commands.Save;
import org.apache.logging.log4j.LogManager;
import utility.CollectionManager;
import utility.Command;
import utility.Invoker;
import utility.Respond;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import org.apache.logging.log4j.Logger;

public class UDPServer {
    static DatagramSocket datagramSocket;
    static ByteBuffer receivingDataBuffer = ByteBuffer.allocate(10240);
    static ByteBuffer sendingDataBuffer = ByteBuffer.allocate(10240);
    static DatagramPacket inputPacket;

    static CollectionManager collectionManager = new CollectionManager();
    static Invoker invoker = new Invoker(collectionManager);
    public static String filePath;
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.info("The server has started working");

        if(args.length==0){
            logger.error("There is no path to the file to save the data");
            System.exit(1);
        }
        try {
            datagramSocket = new DatagramSocket(50001);
            while (true) {
                Command command = read();
                logger.info("Transmitted command: " + command.getCommandName());
                if (command.getCommandName().equals("exit")) {
                    logger.info(new Save(collectionManager).execute(args[0]).answer);
                } else {
                    Respond respond = invoker.execute(command);
                    logger.info("Response from the server: " + respond.answer);
                    write(respond);
                }
            }
        } catch (SocketException e) {
            e.getStackTrace();
            logger.error(e.getMessage(),e);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
    }

    private static byte[] serialize(Object obj) throws IOException {
        try (ByteArrayOutputStream b = new ByteArrayOutputStream()) {
            try (ObjectOutputStream o = new ObjectOutputStream(b)) {
                o.writeObject(obj);
            }catch (Exception e){
                logger.error("Serialization error");
            }
            return b.toByteArray();
        }
    }

    private static Command read() throws IOException, ClassNotFoundException {
        receivingDataBuffer.clear();
        inputPacket = new DatagramPacket(receivingDataBuffer.array(), receivingDataBuffer.capacity());
        datagramSocket.receive(inputPacket);
        logger.info("Package received");
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(inputPacket.getData()));
        return (Command) objectInputStream.readObject();
    }

    private static void write(Respond respond) throws IOException {
        sendingDataBuffer.clear();
        sendingDataBuffer.put(serialize(respond));
        InetAddress senderAddress = inputPacket.getAddress();
        int senderPort = inputPacket.getPort();

        DatagramPacket outputPacket = new DatagramPacket(sendingDataBuffer.array(), sendingDataBuffer.limit(), senderAddress, senderPort);
        datagramSocket.send(outputPacket);
        logger.info("The package has been sent");
    }
}
