/**
 * The command class for add_if_max.
 */

package commands;

import data.Ticket;
import utility.CollectionManager;
import utility.Respond;

import java.util.function.Consumer;

public class Add_if_max extends Add{

    final int countOfArguments = 10;

    /**
     * Class constructor
     *
     * @param collection class for add new elements to collection
     */
    public Add_if_max(CollectionManager collection) {
        super(collection);
    }

    @Override
    public Respond execute(Object argument) {
        Ticket ticket = (Ticket) argument;
        if (collectionManager.last().compareTo(ticket)>0){
            return new Add(collectionManager).execute(ticket);
        }else{
            System.out.println("The object was not added");
            return new Respond("The object was not added");
        }
    }
}
