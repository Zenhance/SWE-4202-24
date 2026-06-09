public class PriorityEmailMessage extends EmailMessage {
    private static final double PRIORITY_SURCHARGE = 0.30;

    public PriorityEmailMessage(Recipient recipient, String body) {
        super(recipient, body);
    }

    public String deliver() {
        return ("Priority mail " + super.deliver());
    }

    public double cost() {
        return (super.cost() + PRIORITY_SURCHARGE);
    }

    public String describe() {
        return ("Email send to " +getRecipient().getName() + " " + getRecipient().getAddress());
    }


}
