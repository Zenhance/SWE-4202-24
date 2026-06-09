public class Outbox
{
    private Message[] messages;
    private int count;

    public Outbox(Message[] messages, int count)
    {
        messages = new Message[30];
        count=0;
    }


}