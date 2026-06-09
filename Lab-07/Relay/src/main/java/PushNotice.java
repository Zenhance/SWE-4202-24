public class PushNotice extends Notice {

    private static final int LENGTH = 40;
    private static final double COST = 0.10;

    public PushNotice(Recipient recipient, String text) {
        super(recipient, text);
    }

    private String preview() {
        if (getText().length() <= LENGTH) {
            return getText();
        }
        return getText().substring(0, LENGTH);
    }

    @Override
    public String deliver() {
        return "To " + getRecipient().getName() + " <" + getRecipient().getAddress() + ">: " + preview();
    }

    @Override
    public double cost() {
        return COST;
    }

    @Override
    public String describe() {
        return "Notice send to " + getRecipient().getName() + " preview-- " + preview();
    }
}