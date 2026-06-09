public class SmsMessage extends Notice{
    public SmsMessage(Recipient r, String txt){
        super(r,txt);
    }
    @Override
    public String deliver() {
        int segments = txt.length()/160;
        String msg = segments + txt;
        return msg;
    }

    @Override
    public double cost() {
        return (double) txt.length()/160.0 * 50.0;
    }
}
