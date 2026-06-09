public class EmailMessage extends Message {
    public EmailMessage(Recipient recipient, String body) {
        super(recipient, body);
    }

    public String deliver() {
        return ("To" + getRecipient().getName() + " " + getRecipient().getAddress() + getBody());
    }

    public double cost() {
        return 0.0;
    }

    public String describe() {
        return ("Mail send to " + getRecipient().getName() + " " + getRecipient().getAddress());
    }
}
