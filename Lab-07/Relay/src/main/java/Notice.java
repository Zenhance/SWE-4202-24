public abstract class Notice {
    private final Recipient recipient;
    private final String text;

    protected Notice(Recipient recipient, String text){
        this.recipient=recipient;
        this.text=text;
    }

    protected Recipient getRecipient() {
        return recipient;
    }

    protected String getText() {
        return text;
    }

    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();

}