public class SMSNotice extends Notice{
     private static final double COST_PER_SEGMENT = 0.10;
    public SMSNotice(Recipient recipient,   String text) {
        super(recipient,text);
    }
    private int getSegmentCount(){
        return (getText().length() + 159)/160;
    }


}
