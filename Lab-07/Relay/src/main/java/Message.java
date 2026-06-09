public abstract class Message {
    protected Recipient recipient;
    protected String text;
    public Message(Recipient recipient, String text){
        this.recipient=recipient;
        this.text=text;
    }
    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}