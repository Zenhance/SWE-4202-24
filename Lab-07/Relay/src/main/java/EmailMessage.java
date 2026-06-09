public class EmailMessage extends Notice {
    public EmailMessage(Recipient recipient, String text){
        super(recipient,text);
    }
    @Override
    public String deliver(){
        return "EMAIL TO: " + recipient.getName()+"\n" + text;
    }
    @Override
    public double cost(){
        return 0.0;
    }
    @Override
    public String describe(){
        return "Email Notice";
    }
}
