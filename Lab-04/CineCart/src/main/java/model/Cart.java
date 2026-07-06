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

    public void add(LineItem line)
    {
        if(count<=MAX_LINES)
        {
            lines[count]=line;
            count++;
        }
    }

    public void add(ConcessionItem item)
    {
        add(item,1);
    }

    public void add(ConcessionItem item, int qty)
    {
        if(qty>0)
        {
            add(new ConcessionLine(item,qty));
        }
    }

    public boolean hasCode(String code)
    {
        for(int i=0;i<count;i++)
        {
            if(lines[i].hashCode(code))
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

    public int getTicketCount()
    {
        int t=0;
        return t;
    }
}