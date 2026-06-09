public class SmsMessage extends Notice{
    public SmsMessage(Recipient r, String txt){
        super(r,txt);
    }
    @Override
    public String deliver() {
        return "";
    }

    @Override
    public double cost() {
        return (double) txt.length()/160.0 * 50.0;
    }
}
