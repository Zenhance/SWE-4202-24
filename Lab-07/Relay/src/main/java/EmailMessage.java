public class EmailMessage extends Notice{
    public EmailMessage(Recipient recipient,String text) {
        super(recipient,text);
    }
    @Override
    public String deliver() {
        return "Email to " + recipient.getName() + " " + recipient.getAddress()+" "+text;
    }
    @Override
    public double cost() {
        return 0.0;
    }
}
