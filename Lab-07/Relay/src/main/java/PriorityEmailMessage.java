public class PriorityEmailMessage extends EmailMessage
{
    private static final double SURCHARGE = 0.25;
    String priorityFlag = "PRIORITY";

    public PriorityEmailMessage(Recipient recipient, String text)
    {
        super(recipient,text);
    }

}