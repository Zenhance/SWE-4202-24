public class EmailMessage extends Notice{
    public EmailMessage (Recipient recipient, String text){
        super(recipient,text);
    }

    @Override
    public double cost() {
        return 0.0;
    }
