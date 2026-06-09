public abstract class Notice {
    private String text;
    private Recipient recipient;

    public Notice(String text, Recipient recipient) {
        this.text = text;
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public Recipient getRecipient() {
        return recipient;
    }

}
