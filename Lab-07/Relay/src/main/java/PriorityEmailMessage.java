public class PriorityEmailMessage extends EmailMessage {
    String priorityFlag = "priority";

    public PriorityEmailMessage(Recipient r, String txt) {
        super(r, txt);
    }

    @Override
    public String deliver(){
        return priorityFlag + r.getName() + r.getAddress() + txt;
    }

    @Override
    public double cost(){
        return 0.3;
    }

    @Override
    public String describe(){
        return "PRIORITY";
    }
}
