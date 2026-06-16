public class PriorityEmailMessage extends EmailMessage {
    private static final double SURCHARGE = 0.30;

    public PriorityEmailMessage(Recipient r, String body) {
        super(r, body);
    }

    @Override
    public String deliver() {
        return "PRIORITY: " + super.deliver();
    }
    @Override
    public double cost() {
        return super.cost() + SURCHARGE;
    }

    @Override
    public String describe() {
        return "PRIORITY EMAIL notice for " + recipient.getName();
    }
}