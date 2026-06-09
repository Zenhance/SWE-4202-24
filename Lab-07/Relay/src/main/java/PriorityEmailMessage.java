public class PriorityEmailMessage extends EmailMessage{

    public PriorityEmailMessage(Recipient recipient,String text) {
        super(recipient,text);
    }

    @Override
    public String deliver() {
        return "Priority Email to " + recipient.getName() + " " + recipient.getAddress()+" "+text;
    }

    @Override
    public double cost() {
        return 0.3;
    }

    @Override
    public String describe() {
        return "PRIORITY";
    }
}
