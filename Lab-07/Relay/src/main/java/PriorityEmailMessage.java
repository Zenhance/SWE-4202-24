public class PriorityEmailMessage extends EmailMessage {
    public PriorityEmailMessage(Recipient name, String text) {
        super(name, text);
    }


    public double cost() {
        return 0.3;

    }

    @Override
    public String deliver() {
        return "plainEmailLine"+super.deliver();
    }

    @Override
    public String describe() {
        return "PRIORITY";
    }
}
