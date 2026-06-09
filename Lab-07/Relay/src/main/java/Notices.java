public abstract class Notices {
    private Recipient recipient;
    private String text;

    Notices(Recipient recipient, String text) {
        this.recipient=recipient;
        this.text=text;
    }
}
