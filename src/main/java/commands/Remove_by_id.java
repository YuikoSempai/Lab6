package commands;

import data.Ticket;
import utility.CollectionManager;
import utility.Respond;

import java.util.function.Consumer;

/**
 * The command class for remove_by_id.
 */
public class Remove_by_id extends AbstractCommand{
    final int countOfArguments = 1;
    /**
     * Class constructor
     *
     * @param collection class for remove elements from collection
     */
    public Remove_by_id(CollectionManager collection) {
        super(collection);
    }


    /**
     * Removes an item from the collection if its id the input value.
     * @param argument id of elements which we need to remove
     * @return
     */
    @Override
    public Respond execute(Object argument) {
        collectionManager.removeIf(ticket -> ticket.getId() == Long.parseLong((String) argument));
        return new Respond("Objects have been deleted");
    }
}