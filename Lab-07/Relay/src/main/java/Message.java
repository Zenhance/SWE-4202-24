public abstract class Message {
    protected Recipient recipient;
    protected String body;

    public Message(Recipient recipient, String body) {
        this.recipient = recipient;
        this.body = body;
    }

    public abstract double cost();

    public abstract String deliver();

    public abstract String describe();
}
