public class SmsMessage extends Message
{
    private static final double COST_PER_SEGMENT = 0.10;

    public SmsMessage(Recipient recipient, String text)
    {
        super(recipient,text);
    }

    private int segment()
    {
        return (text.length()+159)/160;
    }

    @Override
    public String deliver()
    {
        return "SMS ( "+segment()+" segments ) "+text;
    }

    @Override
    public double cost()
    {
        return segment()*COST_PER_SEGMENT;
    }

    @Override
    public String describe()
    {
        return "SMS";
    }
}
