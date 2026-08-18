public class PriorityEmailNotice extends EmailNotice{

    private static final double SURCHANGE = 0.50;
    public PriorityEmailNotice(Recipient recipient, String text){
        super(recipient,text);
    }

    @Override
    public String deliver(){
        return "[PRIORITY] " + super.deliver();
    }

    @Override
    public double cost(){
        return super.cost() + SURCHANGE ;
    }

    @Override
    public String describe(){
        return "Priority Email Notice";
    }
}
