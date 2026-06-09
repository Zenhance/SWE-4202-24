public class PriorityEmailMessage extends EmailMessage
{
    private static final double SURCHARGE = 0.25;
    String priorityFlag = "PRIORITY";

    public PriorityEmailMessage(Recipient recipient, String text)
    {
        super(recipient,text);
    }

    @Override
    public double cost()
    {
        return SURCHARGE;
    }

    @Override
    public String describe()
    {
        return "PRIORITY";
    }

    @Override
    public String deliver()
    {
        return priorityFlag+" "+recipient.getName()+" "+recipient.getAddress()+" "+text;
    }
}