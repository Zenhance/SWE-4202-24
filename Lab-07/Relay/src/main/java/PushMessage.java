public class PushMessage extends Message {
    private static final double FLAT_COST = 0.02; // Example flat cost
    private static final int MAX_PREVIEW_LENGTH = 40;
    public PushMessage(Recipient recipient, String text) {
        super(recipient, text);
    }

    @Override
    public String deliver() {

        String preview = (text.length() <= MAX_PREVIEW_LENGTH)
                ? text
                : text.substring(0, MAX_PREVIEW_LENGTH) + "...";
        return "[PUSH PREVIEW] " + preview;
    }
    @Override
    public double cost() {
        return FLAT_COST;
    }

    @Override
    public String describe() {
        return "Push notification to device ID: " + recipient.getAddress();
    }
}
