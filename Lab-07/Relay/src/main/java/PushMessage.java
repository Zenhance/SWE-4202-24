public class PushMessage extends Message {
    public PushMessage(Recipient recipient,String text) {
        super(recipient,text);
    }
    @Override
    public String deliver() {
        return "Push to " + recipient.getName() + " " + recipient.getAddress()+" "+text;
    }
    @Override
    public double cost() {
        return 10.0;
    }

    @Override
    public String describe() {
        return "Push";
    }
}
