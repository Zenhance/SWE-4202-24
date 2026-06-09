abstract class Notice {
    private final Recipient recipient;
    private final String text;

    public Notice(Recipient recipient, String text){
        this.recipient = recipient;
        this.text = text;
    }

    public Recipient getRecipient(){
        return this.recipient;
    }

    public String getString(){
        return this.text;
    }

    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}
