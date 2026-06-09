public class PriorityEmailMessage extends EmailMessage {

    private static final double CHARGE = 1.25;

    public PriorityEmailMessage(Recipient recipient, String text) {
        super(recipient, text);
    }

    @Override
    public String deliver() {
        return " priority email- " + super.deliver();
    }

    @Override
    public double cost() {
        return super.cost() + CHARGE;
    }

    @Override
    public String describe() {
        return "priority " + super.describe();
    }
}
