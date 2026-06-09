public class PriorityEmailNotice extends EmailNotice {
    private static final double EXPRESS_SURCHARGE = 1.25;

    public PriorityEmailNotice(Recipient recipient, String text) {
        super(recipient, text);
    }

    @Override
    public String deliver() {
        return "[PRIORITY] " + super.deliver();
    }

    @Override
    public double cost() {
        return super.cost() + EXPRESS_SURCHARGE;
    }

    @Override
    public String describe() {
        return "Priority " + super.describe();
    }
}