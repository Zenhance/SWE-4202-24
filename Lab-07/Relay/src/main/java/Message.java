public abstract class Message {
    protected String text;
    protected Recipient recipient;

    public Message(Recipient recipient, String text) {
        this.text = text;
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public abstract String deliver();
    public abstract double cost();
}

