public class Message {
    protected final Recipient recipient;
    protected final String body;

    protected Message(Recipient recipient,String body){
        this.recipient=recipient;
        this.body=body;
    }
    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();

}
