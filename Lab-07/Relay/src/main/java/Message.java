public abstract class Message {
    protected String text;
    protected Recipient recipient;

    public Message(Recipient recipient, String text) {
        this.text = text;
        this.recipient = recipient;
    }

    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}

