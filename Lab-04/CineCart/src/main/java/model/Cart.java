package model;

public class Cart
{
    private Customer owner;
    private LineItem[] lines;
    private int count;

    public static final int MAX_LINES = 40;

    public Cart(Customer owner)
    {
        this.owner = owner;
        lines = new LineItem[MAX_LINES];
        count = 0;
    }

    public Customer getOwner()
    {
        return owner;
    }

    public LineItem[] getLines()
    {
        LineItem[] l = new LineItem[count];
        for(int i=0;i<count;i++)
        {
            l[i]=lines[i];
        }
        return l;
    }

    public int getCount()
    {
        return count;
    }

    public boolean add(LineItem line)
    {
        if(count<=MAX_LINES)
        {
            lines[count]=line;
            count++;
            return true;
        }
        return false;
    }
    public boolean add(ConcessionItem item, int qty)
    {
        if(qty>0)
        {
            return add(new ConcessionLine(item,qty));
        }
        return false;
    }

    public double sumTicketsPaid()
    {
        double sum=0.0;
        for(int i=0;i<count;i++)
        {
            sum=sum+lines[i].getPricePaid();
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

    public boolean hasCode(String code)
    {
        for(int i=0;i<count;i++)
        {
            if(items[i].getCode().equals(code))
            {
                return true;
            }
        }
        return false;
    }

    public double grandSubtotal()
    {
        double total=0.0;
        for(int i=0;i<count;i++)
        {
            total=total+lines[i].subtotal();
        }
        return total;
    }

    public void getTicketCount()
    {

    }
}