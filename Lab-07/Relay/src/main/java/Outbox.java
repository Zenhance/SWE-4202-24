public class Outbox
{
    private Message[] messages;
    private int count;

    public Outbox(Message[] messages, int count)
    {
        messages = new Message[30];
        this.count=0;
    }

    public void enqueue(Message message)
    {
        messages[count]=message;
        count++;
    }

    public void enqueue(Message message, int repeat)
    {
        for(int i=0;i<repeat;i++)
        {
            enqueue(message);
        }
    }

    public double totalCost()
    {
        double total=0.0;
        for(int i=0;i<count;i++)
        {
            total=total+messages[i].cost();
        }
        return total;
    }

    public int size()
    {
        return count;
    }
}