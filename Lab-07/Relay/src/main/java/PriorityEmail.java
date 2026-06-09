class PriorityEmail extends Email {
    private final double surcharge = 1.50;

    public PriorityEmail(Recipient recipient, String text) {
        super(recipient, text);
    }

    @Override
    public String deliver() {
        return "[PRIORITY] " + super.deliver();
    }

    @Override
    public double cost() {
        return super.cost() + surcharge;
    }

    @Override
    public String describe() {
        return "Priority " + super.describe();
    }
}