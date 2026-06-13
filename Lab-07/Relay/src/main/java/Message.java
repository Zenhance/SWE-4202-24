public abstract class Message {

    protected final Recipient NAME;
    protected String text;


    public Message(Recipient name,String text) {
        NAME = name;
        this.text=text;
    }
    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}
