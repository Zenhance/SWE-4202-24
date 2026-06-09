public class EmailMessage extends Notice{
    public EmailMessage (Recipient recipient, String text){
        super(recipient,text);
    }

    @Override
    public double cost() {
        return 0.0;
    }

    @Override
    public String deliver() {
        return String.format("%s\n %s",recipient.getName());
    }