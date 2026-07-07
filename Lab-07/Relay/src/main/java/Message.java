public abstract class Message {
    private Recipient recipient;
    private String body;

    public Message(Recipient recipient, String body){
        this.recipient=recipient;
        this.body=body;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public String getBody() {
        return body;
    }

    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}
