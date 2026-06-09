public class PushMessage extends Notice
{
    private static final int PREVIEW_LENGTH = 40;
    private static final double COST_PER_TRIMMED = 0.50;

    public PushMessage(Recipient recipient, String text)
    {
        super(recipient,text);
    }

    @Override
    public String deliver()
    {
        String preview="";
        if(text.length()<=PREVIEW_LENGTH)
        {
            preview=text;
        }
        return "PUSH : "+preview;
    }

    @Override
    public double cost()
    {
        return COST_PER_TRIMMED;
    }
}