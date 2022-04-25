package commands;

import data.Ticket;
import utility.CollectionManager;
import utility.Respond;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * The command class for group_counting_by_price.
 */
public class Group_counting_by_price extends AbstractCommand{
    /**
     * Class constructor
     *
     * @param collection class for work with collection
     */
    public Group_counting_by_price(CollectionManager collection) {
        super(collection);
    }
    
    /**
     * Groups objects by price and displays the number of objects in each group
     * @param argument empty list
     * @return
     */
    @Override
    public Respond execute(Object argument) {
        Map<Double, Integer> priceMap = new HashMap<>();
        String ans="";
        for (Ticket ticket : collectionManager.getAllElements()) {
            priceMap.put(ticket.getPrice(), priceMap.getOrDefault(ticket.getPrice(),0)+1);
        }
        for (Map.Entry<Double, Integer> entry : priceMap.entrySet()) {
            ans += entry.getKey() + " " + entry.getValue() + "\n";
//            System.out.println(entry); - то же самое, только вместо пробела =
        }
        return new Respond(ans);
    }
}
