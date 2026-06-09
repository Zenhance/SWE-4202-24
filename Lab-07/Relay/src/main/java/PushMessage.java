public class PushMessage extends Message {
    public PushMessage(Recipient recipient,String text) {
        super(recipient,text);
    }
    @Override
    public String deliver() {
        if(text.length()>=40){
            text=text.substring(0,40);// don't know why work on 40 and not 39
            return "Push to " + recipient.getName() + " " + recipient.getAddress()+" "+text;
        }
        else {
            return "Push to " + recipient.getName() + " " + recipient.getAddress() + " " + text;
        }
    }
    @Override
    public double cost() {
        return 0.1;
    }

    @Override
    public String describe() {
        return "Push";
    }
}
