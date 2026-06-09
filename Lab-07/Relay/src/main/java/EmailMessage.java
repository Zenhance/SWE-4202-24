public class EmailMessage extends Message{
    public EmailMessage(Recipient recipient, String body) {
        super(recipient, body);
    }

    @Override
    public double cost() {
        return 0.0;
    }

    @Override
    public String deliver() {
        return String.format("Header: %s\n"
                                + body, recipient.getName());
    }

    @Override
    public String describe() {
        return "EMAIL";
    }
}
