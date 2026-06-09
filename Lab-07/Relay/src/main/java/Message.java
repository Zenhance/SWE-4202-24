abstract class Message {
    private final Recipient recipient;
    private final String text;

    public Message(Recipient recipient, String text){
        this.recipient = recipient;
        this.text = text;
    }

    public Recipient getRecipient(){
        return this.recipient;
    }

    public String getText(){
        return this.text;
    }

    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}
