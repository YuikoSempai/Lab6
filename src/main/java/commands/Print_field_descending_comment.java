package commands;

import data.Ticket;
import utility.CollectionManager;
import utility.Respond;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * The command class for print_filed_descending_comment.
 */
public class Print_field_descending_comment extends AbstractCommand {
    /**
     * Class constructor
     *
     * @param collection class for work with collection
     */
    public Print_field_descending_comment(CollectionManager collection) {
        super(collection);
    }


    /**
     * Print the values of the comment field of all elements in descending order
     * @param argument empty list
     * @return
     */
    @Override
    public Respond execute(Object argument) {

        List<String> commentFields = new ArrayList<>();

        for (Ticket ticket: collectionManager.getAllElements()) {
            commentFields.add(ticket.getComment());
        }
        String ans="";
        for (int i = commentFields.size()-1;i>=0;i--){
            ans += commentFields.get(i)+ "\n";
        }
        ans+="\n";
        return new Respond(ans);
    }
}