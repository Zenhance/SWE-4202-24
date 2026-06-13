public class PushMessage extends Message {
    private static final double FLAT_RATE = 0.1;
    private static final int PREVIEW_LIMIT = 40;

    public PushMessage(Recipient recipient, String text) {
        super(recipient, text);
    }
}