public class EmailNotice extends Notice{

    public EmailNotice(Recipient recipient, String text) {
        super(recipient, text);
    }

    @Override
    public String deliver() {
        return "To " + getRecipient().getName() + " <" + getRecipient().getAddress() + ">: " + getText();
    }

    @Override
    public double cost() {
        return 0.0;
    }

    @Override
    public String describe() {
        return "Email to: " + getRecipient().getName() + " at " + getRecipient().getAddress();
    }

}
