/**
 * The command class for clear.
 */

package commands;

import data.Ticket;
import utility.CollectionManager;
import utility.Respond;

import java.util.function.Consumer;

public class Clear extends AbstractCommand {
    /**
     * Class constructor
     *
     * @param collection class for work with collection
     */
    public Clear(CollectionManager collection) {
        super(collection);
    }

    public int getCountOfArguments() {
        return 0;
    }

    /**
     * Clears the collection
     * @param argument = null
     * @return
     */
    @Override
    public Respond execute(Object argument) {
        collectionManager.clear();
        return new Respond("The collection has been cleared");
    }
}
