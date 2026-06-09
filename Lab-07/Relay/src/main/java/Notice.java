public abstract class Notice {
    protected final Recipient recipient;
    protected final String text;

    protected Notice(Recipient recipient, String text){
        this.recipient = recipient;
        this.text = text;
    }
    public abstract String deliver();
    public abstract double price();
    public abstract String describe();
}