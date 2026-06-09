public abstract class Message {
     private final Recipient recipient;
    private final String text;

    private Message(Recipient recipient,String text){
        if(recipient==null || text==null){
            throw  ("Recipient and text cannot be null");
        }
        this.recipient=recipient;
        this.text=text;
    }
    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}
