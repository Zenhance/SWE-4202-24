public class SMSMessage extends Notice{
    public SMSMessage(Recipient recipient, String text){
        super (recipient,text);
    }
    private int segments(){
        return (text.length()+159)/160;
    }
    @Override
    public String deliver(){
        return "SMS ( " +segments() + "segments):" + text;
    }
    @Override
    public double cost(){
        return segments() * 0.50;
    }
    @Override
    public String describe(){
        return "SMS NOTICE ";
    }
}
