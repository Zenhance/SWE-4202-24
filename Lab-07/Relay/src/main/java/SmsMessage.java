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
        return 0;
    }
}
