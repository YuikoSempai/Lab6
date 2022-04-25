/**
 * The command class for add.
 */

package commands;

import data.Ticket;
import utility.CollectionManager;
import utility.Respond;

import java.util.function.Consumer;


public class Add extends AbstractCommand {
    final int countOfArguments = 10;
    /**
     * Class constructor
     *
     * @param collection class for add new elements to collection
     */
    public Add(CollectionManager collection){
        super(collection);
    }
    public int getCountOfArguments() {
        return countOfArguments;
    }


    public Respond execute(Object argument) {
        Ticket ticket = (Ticket) argument;
        collectionManager.add(ticket);
        return new Respond("Object added");
    }
}