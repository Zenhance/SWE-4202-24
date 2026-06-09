public class PriorityEmailMessage extends EmailMessage {
    String priorityFlag = "priority";

    public PriorityEmailMessage(Recipient r, String txt) {
        super(r, txt);
    }

    @Override
    public String deliver(){
        return priorityFlag+txt;
    }
}
