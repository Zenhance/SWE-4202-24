public abstract class Message {
    private Recipient recipient;
    private String text;

    public Message(Recipient recipient, String text) {
        this.recipient = recipient;
        this.text = text;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }

    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}
