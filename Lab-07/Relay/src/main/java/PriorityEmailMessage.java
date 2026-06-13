public class PriorityEmailMessage extends EmailMessage {
    public PriorityEmailMessage(Recipient name, String text) {
        super(name, text);
    }


    public double cost() {
        return 0.9;

    }

    @Override
    public String deliver() {
        return "PRIORITY"+super.deliver();
    }

    @Override
    public String describe() {
        return "PriorityEmailMessage";
    }
}
