public abstract class Notice {
    protected Recipient recipient;
    private String text;

    public Notice (Recipient recipient, String text){
        this.recipient = recipient;
        this.text = text;
    }

    public abstract double cost();

    public abstract String describe();

    public abstract String deliver();
}
