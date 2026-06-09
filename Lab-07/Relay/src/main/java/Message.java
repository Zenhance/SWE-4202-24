public abstract class Message
{
    protected Recipient recipient;
    protected String text;

    public Message(Recipient recipient, String text)
    {
        if(text==null || text.isBlank())
        {
            throw new IllegalArgumentException("NO Text");
        }
        this.recipient = recipient;
        this.text = text;
    }

    public Recipient getRecipient()
    {
        return recipient;
    }

    public String getText()
    {
        return text;
    }

    public abstract String deliver();

    public abstract double cost();

    public abstract String describe();
}