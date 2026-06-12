public class Outbox
{
    private Message[] messages = new Message[30];
    private int count = 0;

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

    public  String flush()
    {
        String chat="";
        for(int i=0;i<count;i++)
        {
            chat=chat+messages[i].deliver();
        }
        return chat;
    }
}