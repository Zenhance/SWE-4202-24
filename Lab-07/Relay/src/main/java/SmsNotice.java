public class SmsNotice extends Notice {

    private static final int SMS_SEGMENT_SIZE = 160;
    private static final double CHARGE_PER_SEGMENT = 0.5;

    public SmsNotice(String text, Recipient recipient) {
        super(recipient, text);
    }

    public String medium() {
        return "SMS";
    }

    public double cost() {
        int textLength = text.length();

        int segmentCount = textLength/SMS_SEGMENT_SIZE;
        double charge = segmentCount*CHARGE_PER_SEGMENT;

        return charge;
    }

}