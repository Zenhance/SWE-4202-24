public class EmailMessage extends Message {
    public EmailMessage(Recipient r, String text){
        super(r,text);
    }
    @Override
    public String deliver() {
        return "Email to "+recipient.getName();
    }

    @Override
    public double cost() {
        return 0;

    }

    @Override
    public String describe() {
        return "Email Notice";
    }
}
