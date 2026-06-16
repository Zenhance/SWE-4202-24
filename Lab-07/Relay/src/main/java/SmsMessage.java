public class SmsMessage extends Message{
    private static final int    SMS_SEGMENT_SIZE   = 160;   // chars per SMS segment
    private static final double SMS_PER_SEGMENT    = 0.50;
     public Recipient r;
     public String body;
    public SmsMessage(Recipient r,String body){
        super(r,body);
    }

    public String deliver(){
        return super.deliver();
    }
    public double cost() {
        return super.cost();
    }



}
