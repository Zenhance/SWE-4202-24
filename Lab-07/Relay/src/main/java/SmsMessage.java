public class SmsMessage extends Message {

    private static final int SIZE = 160;
    private static final double COST= 0.50;

    public SmsMessage(Recipient recipient, String text) {
        super(recipient, text);
    }

    private int segments() {
        int length = getText().length();
        if (length == 0) {
            return 1;
        }
        return (length + SIZE - 1) / SIZE;
    }

    @Override
    public String deliver() {
        return "SMS to " + getRecipient().getName() + " <" + getRecipient().getAddress() + "> [" + segments() + " segment(s)]: " + getText();
    }

    @Override
    public double cost() {
        return segments() * COST;
    }

    @Override
    public String describe() {
        return "SMS notice to " + getRecipient().getName() + " using " + segments() + " segment(s)";
    }
}