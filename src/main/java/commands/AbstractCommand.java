/**
 * Abstract command for all another commands.
 */
package commands;

import commands.interfaces.CommandInterface;
import data.Ticket;
import utility.CollectionManager;
import utility.Respond;

import java.util.function.Consumer;


public abstract class AbstractCommand implements CommandInterface {
    final CollectionManager collectionManager;
    final int countOfArguments = 0;
    /**
     *
     * @param collection collection
     */

    public AbstractCommand(CollectionManager collection) {
        collectionManager = collection;
    }

    /**
     * Executing the command
     * @param argument arguments for our command
     */
    @Override
    public abstract Respond execute(Object argument);

    public int getCountOfArguments(){
        return countOfArguments;
    }
}
