public class SMSNotice extends Notice{
    private static final int    SMS_SEGMENT_SIZE   = 160;
    private static final double SMS_PER_SEGMENT    = 0.50;

    public SMSNotice(Recipient recipient,String text){
        super(recipient,text);
    }
}
