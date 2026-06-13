public class SmsMessage extends Message {
    private static final double COST_PER_SEGMENT = 0.5;

    public SmsMessage(Recipient recipient, String text) {
        super(recipient, text);
    }

    private int calculateSegments() {
        int length = getText().length();
        if (length == 0) {
            return 1;
        }
        return (length + 159) / 160;
    }

    @Override
    public String deliver() {
        return getText() + " (Sent as " + calculateSegments() + " segments)";
    }

    @Override
    public double cost() {
        return calculateSegments() * COST_PER_SEGMENT;
    }

    @Override
    public String describe() {
        return "SMS" + getRecipient().getName();
    }
}