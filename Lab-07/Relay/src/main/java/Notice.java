public abstract class Notice {
    private final Recipient recipient;
    private final String body;
    public Notice(Recipient recipient, String body){
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
