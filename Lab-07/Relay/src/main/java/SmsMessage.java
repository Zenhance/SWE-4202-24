public class SmsMessage extends Message {
    private static final double COST_PER_SEGMENT = 0.5;

    public SmsMessage(Recipient recipient, String text) {
        super(recipient, text);
    }


}