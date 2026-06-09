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
        return super.cost()+2.0;
    }

    @Override
    public String describe() {
        return "Priority Email";
    }
}
