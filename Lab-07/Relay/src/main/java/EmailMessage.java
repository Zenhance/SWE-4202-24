public class EmailMessage extends Notice{
    public EmailMessage(String text, Recipient recipient) {
        super(text, recipient);
    }
    @Override
    public String deliver() {
        return "Email to " + getRecipient().getName() + " at " + getRecipient().getAddress()+getText();
    }
    @Override
    public double cost() {
        return 0.0;
    }
}
