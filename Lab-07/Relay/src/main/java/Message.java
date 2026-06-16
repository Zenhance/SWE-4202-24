import java.util.Collection;

public abstract class Message {
    protected Recipient r;
    protected String body;
    protected String Message;


public abstract String deliver();
public abstract String cost();
public abstract String describe();

}