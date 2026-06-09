public class EmailMessage extends Message{
    public EmailMessage(Recipient recipient,String text){
        super(recipient,text);
    }
    public String deliver(){
        return "EMAIL TO" + recipient.getName() + " (" +recipient.getAddress()+"): " + text;
    }
    public double cost(){
        return 0.0;
    }
    public String describe(){
        return "EMAIL message";
    }
}
