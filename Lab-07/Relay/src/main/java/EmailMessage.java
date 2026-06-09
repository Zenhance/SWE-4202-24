public class EmailMessage extends Message
{
    public EmailMessage(Recipient recipient, String text)
    {
        super(recipient,text);
    }

    @Override
    public String deliver()
    {
        return "E-MAIL to "+recipient.getName()+" "+recipient.getAddress()+" "+text;
    }

    @Override
    public double cost()
    {
        return 0.0;
    }

    @Override
    public String describe()
    {
        return "EMAIL";
    }

}