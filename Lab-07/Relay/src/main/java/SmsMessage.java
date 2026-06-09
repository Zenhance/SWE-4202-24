public class SmsMessage extends Notice
{
    public SmsMessage(Recipient recipient, String text)
    {
        super(recipient,text);
    }

    @Override
    public String deliver()
    {
        return "SMS to "+recipient.getName()+" "+recipient.getAddress()+" "+text;
    }

    @Override
    public double cost()
    {
        return 0.0;
    }
}
