public class SmsMessage extends Notice {
    public SmsMessage(Recipient r,String msg){
        super(r, msg);
    }

    @Override
    public String deliver() {
        int segments = msg.length()/160;
        String txt = segments + msg;
        return txt;
    }

    @Override
    public double cost() {
        return 2.67;
    }
}
