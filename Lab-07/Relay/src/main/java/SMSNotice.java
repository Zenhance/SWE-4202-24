public class SMSNotice extends Notice{
    private static final int    SMS_SEGMENT_SIZE   = 160;
    private static final double SMS_PER_SEGMENT    = 0.50;

    public SMSNotice(Recipient recipient,String text){
        super(recipient,text);
    }

    private int getSmsSegmentSize(){
        int length = getText().length();

        if(length == 0){return 1;}

        return (length+SMS_SEGMENT_SIZE-1)/SMS_SEGMENT_SIZE;
    }

    @Override
    public String deliver(){
        return "SMS to "+getRecipient().getAddress()+" ["+getSmsSegmentSize()+" segment(s)]: "+getText();
    }

}
