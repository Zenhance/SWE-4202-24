public class PriorityEmailMessage extends Message{

    public PriorityEmailMessage(Recipient recipient, String body){
        super(recipient,body);
    }

    public String deliver() {
        return "";
    }


    public double cost() {
        return 0;
    }


    public String describe() {
        return "";
    }
}
