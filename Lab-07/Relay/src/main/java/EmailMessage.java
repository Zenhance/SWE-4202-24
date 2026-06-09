public class EmailMessage extends Message{
    public EmailMessage(Recipient recipient,String text){
        super(recipient,text);
    }
    @Override
    public String deliver() {
        String s = "To: " + recipient.getName() + " <" + recipient.getAddress() + ">";
        return s;
    }
    @Override
    public double cost(){
        return 0.0;
    }
    @Override
    public String describe(){
        String s="Email to "+ recipient.getAddress();
    }
}
