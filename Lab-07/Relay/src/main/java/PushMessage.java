public class PushMessage extends Notice
{
    public PushMessage(Recipient recipient, String text)
    {
        super(recipient,text);
    }

    @Override
    public String deliver()
    {
        return "PUSH to "+recipient.getName()+" "+recipient.getAddress()+" "+text;
    }

    @Override
    public double cost()
    {
        return 0.0;
    }
}