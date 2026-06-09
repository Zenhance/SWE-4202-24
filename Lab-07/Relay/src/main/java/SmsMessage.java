public class SmsMessage extends Notice{
    public SmsMessage(Recipient r, String body) {
        super(r,body);
    }

    @Override
    public String deliver() {
        return body;
    }

    @Override
    public double cost() {
        int length= (int) Math.ceil((double) body.length()/160);
        return length*0.5;
    }

    @Override
    public String describe() {
        return "It is a SMS";
    }

}
