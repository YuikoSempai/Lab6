package utility;

import java.io.Serializable;

public class Command implements Serializable {


    String commandName;

    Object argument;

    public Command(String aCommandName){
        commandName = aCommandName;
    }

    public void setArgument(Object aArgument){
        this.argument = aArgument;
    }
    public Object getArgument(){
        return argument;
    }
    public String getCommandName(){
        return commandName;
    }
}
