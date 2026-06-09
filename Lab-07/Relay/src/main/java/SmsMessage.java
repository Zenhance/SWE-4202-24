public class SmsMessage extends Message{
    private static double cost_pm=0.05;
    private static int limit=160;

    public SmsMessage(Recipient recipient,String text){
        super(recipient,text);
    }
    private int countSegments(){
        if(text==null){
            return 1;
        }
        return (int)text.length()/limit;
    }
    @Override
    public String deliver(){
        int segments=countSegments();
        String s= text+"\n[SMS: Sent as "+ segments+" segment";
                if(segments==1) s+="]";
                else s+="s]";
        return s;
    }
    @Override
    public double cost(){
        return countSegments()*cost_pm;

    }

    @Override
    public String describe() {
        return "SMS to " +recipient.getAddress() +" (" + countSegments() +" segments)";
    }
}
