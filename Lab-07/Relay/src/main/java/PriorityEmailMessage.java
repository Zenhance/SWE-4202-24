public class PriorityEmailMessage extends EmailMessage{
    private static final double PRIORITY_SURCHARGE = 0.30;

    public PriorityEmailMessage(Recipient recipient, String body){
        super(recipient,body);
    }
    public String deliver(){
        return "*PRIORITY*+"+"\n To"  +getRecipient().getName()+" "+getRecipient().getAddress()+"\n"+getBody();
    }

    public double cost(){
        return PRIORITY_SURCHARGE;
    }
    public String describe(){
        return "Priority Email has been sent to "+getRecipient().getName();
    }
}
