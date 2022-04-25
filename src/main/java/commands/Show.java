
package commands;

import data.Ticket;
import utility.CollectionManager;
import utility.Respond;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * The command class for save.
 */
public class Show extends AbstractCommand {
    /**
     * Class constructor
     *
     * @param collection class for show elements from collection
     */
    public Show(CollectionManager collection) {
        super(collection);
    }
    
    /**
     * print all elements of collection.
     * @param argument empty list
     * @return
     */
    @Override
    public Respond execute(Object argument) {
        String ans = "";
        for (Ticket ticket : collectionManager.getAllElements()) {
            ans += ticket.toString()+"\n";
        }
        if(collectionManager.size()==0){
            ans = "At the moment the collection is empty";
            ans += "\n";
        }
        Stream<Ticket> stream = collectionManager.getAllElements().stream();
        return new Respond(ans);
    }
}
