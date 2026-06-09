public class SmsMessage extends Message{
    private static final int SEGMENT_SIZE = 160;
    private static final double COST_PER_SEGMENT=0.50;
    public SmsMessage(Recipient recipient,String text){
        super(recipient,text);
    }
    private int getSegments(){
        return Math.max(1,(int)Math.ceil(text.length()/(double)SEGMENT_SIZE));
    }
    public String deliver(){
        return "SMS (" + getSegments() + " segments): " + text;
    }
    public double cost(){
        return getSegments()* COST_PER_SEGMENT;
    }
    public String describe(){
        return "SMS Message";
    }
}
