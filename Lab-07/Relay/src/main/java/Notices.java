public abstract class Notices {
    private Recipient recipient;
    private String text;

    Notices(Recipient recipient, String text) {
        this.recipient=recipient;
        this.text=text;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public String gettext() {
        return text;
    }
}
