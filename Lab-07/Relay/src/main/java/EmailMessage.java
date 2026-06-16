public class EmailMessage extends Message {

    public EmailMessage(Recipient r, String body) {
        super(r, body);
    }

    @Override
    public String deliver() {
        return "To: " + recipient.getName() + " <" + recipient.getAddress() + ">\n" + body;
    }

    @Override
    public double cost() {
        return 0.0;
    }

    @Override
    public String describe() {
        return "EMAIL notice for " + recipient.getName();
    }
}