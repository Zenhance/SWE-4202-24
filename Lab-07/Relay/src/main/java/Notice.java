public abstract class Notice
{
    protected Recipient recipient;
    protected String text;

    public Notice(Recipient recipient, String text)
    {
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
}