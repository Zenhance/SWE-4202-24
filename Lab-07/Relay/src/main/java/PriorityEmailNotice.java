public class PriorityEmailNotice extends EmailNotice{
    private static final double SURCHARGE=1.0;
    public PriorityEmailNotice(Recipient recipient, String text) {
        super(recipient, text);
    }
    @Override
    public String deliver() {
        return "[PRIORITY]"+super.deliver();
    }

    @Override
    public double cost() {
        return super.cost()+SURCHARGE;

    }

    @Override
    public String describe() {
        return "Priority Email Notice";
    }
}
