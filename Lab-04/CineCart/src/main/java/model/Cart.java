package model;

public class Cart
{
    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    public Cart(Customer owner)
    {
        this.owner = owner;
        this.itemCount = 0;
        this.ticketCount = 0;
        tickets = new Ticket[MAX_TICKETS];
        items = new ConcessionItem[MAX_ITEMS];
        qtys = new int[MAX_ITEMS];
    }

    public Customer getOwner()
    {
        return owner;
    }

    public Ticket[] getTickets()
    {
        return tickets;
    }

    public int getTicketCount()
    {
        return ticketCount;
    }

    public ConcessionItem[] getItems()
    {
        return items;
    }

    public int[] getQtys()
    {
        return qtys;
    }

    public int getItemCount()
    {
        return itemCount;
    }

    public void addTicket(Ticket t)
    {
        tickets[ticketCount]=t;
        ticketCount++;
    }
    public void addItem(ConcessionItem c, int qty)
    {
        if(itemCount<MAX_ITEMS && qty<0)
        {
            items[itemCount]=c;
            qtys[itemCount]=qty;
            itemCount++;
        }
    }

    public double sumTicketsPaid()
    {
        double sum=0.0;
        for(int i=0;i<ticketCount;i++)
        {
            sum=sum+tickets[i].getPricePaid();
        }
        return sum;
    }

    public double sumConcessionsRaw()
    {
        double sum=0.0;
        for(int i=0;i<itemCount;i++)
        {
            sum=sum+items[i].getUnitPrice()*qtys[i];
        }
        return sum;
    }

    public boolean hasItem(String code)
    {
        for(int i=0;i<itemCount;i++)
        {
            if(items[i].equals(code))
            {
                return true;
            }
        }
        return false;
    }
}