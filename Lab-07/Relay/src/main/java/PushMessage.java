public class PushMessage extends Message
{
    private static final int PREVIEW_LENGTH = 40;
    private static final double COST_PER_TRIMMED = 0.10;

    public PushMessage(Recipient recipient, String text)
    {
        super(recipient,text);
    }

    @Override
    public String deliver()
    {
        if(text.length()>=PREVIEW_LENGTH)
        {
            text=text.substring(0,40);
            return "PUSH to "+recipient.getName()+" "+recipient.getAddress()+" "+text;
        }
        else
        {
            return "PUSH to "+recipient.getName()+" "+recipient.getAddress()+" "+text;
        }
    }

    @Override
    public double cost()
    {
        return COST_PER_TRIMMED;
    }

    @Override
    public String describe()
    {
        return "PUSH";
    }
}