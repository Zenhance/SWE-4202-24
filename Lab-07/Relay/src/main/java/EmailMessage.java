public class EmailMessage extends Message{
    public EmailMessage(Recipient recipient, String body){
        super(recipient,body);
    }
    public String deliver(){
        return "To "+getRecipient().getName()+" "+getRecipient().getAddress()+"\n"+getBody();
    }

    public double cost(){
        return 0.0;
    }
    public String describe(){
        return "Email has been sent to "+getRecipient().getName();
    }
}
