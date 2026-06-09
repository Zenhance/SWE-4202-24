public abstract class Message {
    protected Recipient recipient;
    protected String body;

    public Message(Recipient recipient, String body) {
        this.recipient = recipient;
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public abstract double cost();

    public abstract String deliver();

    public abstract String send();

    public abstract String describe();


}
