public class SmsMessage extends Message {
    private static final int SEGMENT_SIZE = 160;
    private static final double PER_SEGMENT = 0.50;

    public SmsMessage(Recipient r, String body) {
        super(r, body);
    }

    private int segments() {
        if (body.length() == 0) return 0;
        return (int) Math.ceil(body.length() / (double) SEGMENT_SIZE);
    }
    @Override
    public String deliver() {
        int seg = segments();
        return body + " (" + seg + " segments)";
    }

    @Override
    public double cost() {
        return segments() * PER_SEGMENT;
    }

    @Override
    public String describe() {
        return "SMS notice for " + recipient.getName();
    }
}