public class SmsMessage extends Message {
    private static  final int SEGMENT_SIZE=160;
    private static final double COST_PER_SEGMENT=2.50;

    public SmsMessage(Recipient recipient, String text){
        super(recipient,text);
    }
    private int segmentCount(){
        int length=getText().length();

        if(length==0){
            return 1;
        }
        return (length + SEGMENT_SIZE -1)/SEGMENT_SIZE;
    }

    public String deliver(){
       return "SMS to "+getRecipient().getAddress()+" ("+segmentCount()+"segment(s)): "+getText();
    }

    @Override
    public double cost() {
        return segmentCount()*COST_PER_SEGMENT;
    }

    @Override
    public String describe() {
        return "SMS notice to "+getRecipient().getName()+" using "+ segmentCount()+" segment(s)";
    }

}
