public class PriorityEmailMessage extends EmailMessage{
    public PriorityEmailMessage(Recipient recipient, String body) {
        super(recipient, body);
    }

    public double cost() {
        return 1.0;
    }

    @Override
    public String deliver() {
        return String.format("Priority Email\n"
                +"Header: %s\n"
                + body, recipient.getName());
    }

    @Override
    public String describe() {
        return "PRIORITY";
    }
}