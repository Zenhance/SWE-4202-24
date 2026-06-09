public abstract class Notices {
    private Recipient recipient;
    private String text;

    public Notices(Recipient recipient, String text) {
        this.recipient=recipient;
        this.text=text;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }

    public abstract String deliver();
    public abstract int cost();
    public abstract String describe();

}
