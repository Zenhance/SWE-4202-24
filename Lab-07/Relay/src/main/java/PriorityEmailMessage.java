public class PriorityEmailMessage extends EmailMessage {
    private static final double PRIORITY_SURCHARGE = 0.30;

    public PriorityEmailMessage(Recipient recipient, String body) {
        super(recipient, body);
    }


}
