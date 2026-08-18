public class SMSNotice extends Notice{
     private static final double COST_PER_SEGMENT = 0.10;
    public SMSNotice(Recipient recipient,   String text) {
        super(recipient,text);
    }
    private int getSegmentCount(){
        return (getText().length() + 159)/160;
    }

    @Override
    public String deliver(){
        return "SMS (" + getSegmentCount() + " segments): " + getText();
    }

    @Override
    public double cost(){
        return getSegmentCount() * COST_PER_SEGMENT;
    }

    @Override
    public String describe(){
        return "SMS Notice";
    }
}
