package commands;

import data.Ticket;
import utility.CollectionManager;
import utility.Respond;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * The command class for remove_greater.
 */
public class Remove_greater extends AbstractCommand {
    final int countOfArguments = 10;
    /**
     * Class constructor
     *
     * @param collection class for remove elements from collection
     */
    public Remove_greater(CollectionManager collection) {
        super(collection);
    }


    /**
     * Removes an item from the collection if an object created based on input values is larger.
     * @param argument arguments for create a new ticket to compare.
     * @return
     */
    @Override
    public Respond execute(Object argument) {
        Stream<Ticket> stream = collectionManager.getAllElements().stream();
        Ticket ticket = (Ticket) argument;
        Remove_by_id remove_by_id = new Remove_by_id(collectionManager);
        stream.filter(x -> x.compareTo(ticket) > 0).forEach(collectionManager::remove);
        return new Respond("Objects have been deleted");
    }
}