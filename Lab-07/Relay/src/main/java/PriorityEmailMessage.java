public class PriorityEmailMessage extends EmailMessage{
    private static final double PRIORITY_SURCHARGE = 0.30;

    public PriorityEmailMessage(Recipient recipient, String text){
        super(recipient,text);
    }
    @Override
    public String deliver(){
        return "[PRIORITY] "+super.deliver();
    }
    @Override
    public double cost(){
        return super.cost();
    }
    @Override
public String describe(){
        return "PRIORITY "+super.describe();
    }
}
