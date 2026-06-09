public class PriorityEmailMessage extends EmailMessage {
    public PriorityEmailMessage(Recipient recipient, String text){
        super(recipient,text);
    }
    @Override
    public String deliver(){
        return "[PRIORITY] " + super.deliver();
    }
    @Override
    public double cost(){
        return super.cost()+0.50;
    }
    @Override
    public String describe(){
        return "Priority email";
    }
}
