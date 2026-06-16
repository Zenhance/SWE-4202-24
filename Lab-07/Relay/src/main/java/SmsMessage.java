public class SmsMessage extends Message{
    private static final int    SMS_SEGMENT_SIZE   = 160;   // chars per SMS segment
    private static final double SMS_PER_SEGMENT   = 0.50;

    public SmsMessage(Recipient recipient, String body){
        super(recipient,body);
    }

    @Override
    public String getBody() {
        return super.getBody();
    }

    private int segmentCount(){
        int x=this.getBody().length();
        return x/SMS_SEGMENT_SIZE;

    }
    public String deliver(){
           String ret;
           ret="To "+getRecipient().getName()+" "+getRecipient().getAddress()+"\n"+getBody();
           for(int i=0;i<this.getBody().length();i=SMS_SEGMENT_SIZE+1+i){
               ret=ret+this.getBody().substring(i,i+SMS_SEGMENT_SIZE+1)+"\n";
           }
           return ret+segmentCount();

    }
    public double cost(){
        return segmentCount()*SMS_PER_SEGMENT;
    }
    public String describe(){
        return "SMS sent to "+getRecipient().getName();
    }


}
