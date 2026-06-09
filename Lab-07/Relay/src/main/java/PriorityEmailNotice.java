public class PriorityEmailNotice extends EmailNotice{
    private static final double SURCHARGE=1.0;
    public PriorityEmailNotice(Recipient recipient, String text) {
        super(recipient, text);
    }
}
