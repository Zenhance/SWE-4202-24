public abstract class Notice {
    protected String text;
    protected Recipient recipient;

    public Notice(Recipient recipient,String text) {
        this.text = text;
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public abstract String deliver();
    public abstract double cost();
}

