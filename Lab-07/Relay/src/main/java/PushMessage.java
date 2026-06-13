public class PushMessage extends Message {
    private static final double FLAT_RATE = 0.1;
    private static final int PREVIEW_LIMIT = 40;

    public PushMessage(Recipient recipient, String text) {
        super(recipient, text);
    }

    @Override
    public String deliver() {
        String originalText = getText();
        if (originalText.length() > PREVIEW_LIMIT) {
            return originalText.substring(0, PREVIEW_LIMIT) + "...";
        }
        return originalText;
    }
}