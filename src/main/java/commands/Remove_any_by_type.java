package commands;

import data.Ticket;
import data.TicketType;
import utility.CollectionManager;
import utility.Respond;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * The command class for remove_any_by_type.
 */
public class Remove_any_by_type extends AbstractCommand {
    final int countOfArguments = 1;
    /**
     * Class constructor
     *
     * @param collection class for remove elements from collection
     */
    public Remove_any_by_type(CollectionManager collection) {
        super(collection);
    }



    /**
     * Removes an item from the collection if its type the input value.
     * @param argument type of elements which we need to remove
     * @return
     */
    @Override
    public Respond execute(Object argument) {
        TicketType type = (TicketType) argument;
        Stream<Ticket> stream = collectionManager.getAllElements().stream();
        stream.filter(x->x.getType().compareTo(type)==0).forEach(collectionManager::remove);
        return new Respond("Objects have been deleted");

//        Iterator<Ticket> iter = collectionManager.iterator();
//        while (iter.hasNext()) {
//            Ticket ticket = (Ticket) iter.next();;
//            if (ticket.equalsByType(type)) {
//                iter.remove();
//            }
//
//        }
    }
}
