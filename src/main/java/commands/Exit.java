/**
 * The command class for exit.
 */

package commands;

import data.Ticket;
import utility.CollectionManager;
import utility.Respond;

import java.util.function.Consumer;

public class Exit extends AbstractCommand {
    /**
     * Class constructor
     *
     * @param collection class for work with collection
     */
    public Exit(CollectionManager collection) {
        super(collection);
    }
    
    /**
     * Exits the program
     * @param argument empty list
     * @return
     */
    @Override
    public Respond execute(Object argument) {
        System.out.println("Completion of execution");
        return null;
    }
}
