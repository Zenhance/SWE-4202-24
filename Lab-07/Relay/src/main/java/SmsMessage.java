public class SmsMessage extends Message {
    private static final double COST_PER_SEGMENT = 0.05; // Example per-segment cost

    public Message(Recipient recipient, String body) {
        super(recipient, body);
    }
