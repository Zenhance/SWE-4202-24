public class SmsMessage extends Message {
    private static final int SMS_SEGMENT_SIZE = 160;   // chars per SMS segment
    private static final double SMS_PER_SEGMENT = 0.50;

    public SmsMessage(Recipient recipient, String body) {
        super(recipient, body);
    }

    private int segmentCount() {
        int len = getBody().length();
        return len / SMS_SEGMENT_SIZE;
    }

    public String deliver() {
        return ("SMS " + "Total segments " + segmentCount() + " " + getBody());
    }

    public double cost() {
        return segmentCount() * SMS_PER_SEGMENT;
    }

    public String describe() {
        return ("SMS send to " + getRecipient().getName() + " " + getRecipient().getAddress());
    }


}
