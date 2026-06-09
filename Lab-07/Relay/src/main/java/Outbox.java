public class Outbox
{
    private Message[] messages;
    private int count;

    public Outbox(Message[] messages, int count)
    {
        messages = new Message[30];
        count=0;
    }

    public void enqueue(Message message)
    {
        messages[count]=message;
        count++;
    }

    public void enqueue(Message message, int repeat)
    {
        for(int i=0;i<count;i++)
        {
            enqueue(message);
        }
    }
}