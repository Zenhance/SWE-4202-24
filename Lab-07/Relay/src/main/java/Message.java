public abstract class Message {
    protected Recipient recipient;
    protected String message;

    public Message(Recipient recipient, String message){
        if(message == null || message.isEmpty()){
            throw new IllegalArgumentException("Empty message");
        }
        this.recipient = recipient;
        this.message = message;
    }
}
