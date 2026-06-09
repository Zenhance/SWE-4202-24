public class SMSNotice extends Notice {
    private static final int SEGMENT_SIZE = 160;
    private static final double COST_PER_SEGMENT = 0.50;

    public SMSNotice(Recipient recipient, String text) {
        super(recipient, text);
    }

    private int segments(){
        int length = getText().length();

        if(length==0){
            return 1;
        }

        return (length+SEGMENT_SIZE-1)/SEGMENT_SIZE;
    }

    @Override
    public String deliver() {
        return "SMS to " + getRecipient().getName()
                + " <" + getRecipient().getAddress() + "> ["
                + segments() + " segment(s)]: "
                + getText();
    }

    @Override
    public double cost() {
        return segments() * COST_PER_SEGMENT;
    }

    @Override
    public String describe() {
        return "SMS notice to " + getRecipient().getName()
                + " using " + segments() + " segment(s)";
    }
}