public class PriorityEmailMessage extends EmailMessage {
    public PriorityEmailMessage(Recipient name, String text) {
        super(name, text);
    }

    public double cost() {
        return 1.0;
    }
}
