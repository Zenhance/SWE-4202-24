public abstract class Message{
    public Recipient recipient;
    public String text;
    public Message(Recipient recipient, String text){
        this.recipient=recipient;
        this.text=text;
    }
    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}