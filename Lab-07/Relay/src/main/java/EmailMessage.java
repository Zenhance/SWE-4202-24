public class EmailMessage extends Message {
    public EmailMessage(Recipient recipient, String message){
        super(recipient, message);
    }
    @Override
    public String deliver(){
        String t = "E-Mail to " + recipient.getName()+" "+recipient.getAddress()+" "+message;
        return t;
    }

    @Override
    public double cost(){
        return 0.0d;
    }

    @Override
    public String describe(){
        return "E-Mail";
    }
}
