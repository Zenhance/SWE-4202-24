public abstract class Message{
     public final Recipient recipient;
    public final String text;

    public Message(Recipient recipient,String text){
        if(recipient==null || text==null){
            throw new IllegalArgumentException("Recipient and text cannot be null");
        }
        this.recipient=recipient;
        this.text=text;
    }
    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}
