public class PriorityEmailMessage extends EmailMessage {
    private static final double SURCHARGE=0.3;

    public PriorityEmailMessage(Recipient recipient, String text){
        super(recipient,text);
    }
    @Override
public String deliver(){
        return "[PRIORITY] "+ super.deliver();
}
@Override
public double cost(){
        return super.cost() + SURCHARGE;
}
@Override
    public String describe(){
        return "PRIORITY "+ super.describe();
}
}
