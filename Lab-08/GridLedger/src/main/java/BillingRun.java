import java.util.ArrayList;
import java.util.List;

public class BillingRun
{
    List<Connection> connections = new ArrayList<>();

    public int size()
    {
        return connections.size();
    }

    public List<Invoice> execute()
    {
        List<Invoice> invoices = new ArrayList<>();
        for(Connection c : connections)
        {
            invoices.add(new Invoice(c));
        }
        return invoices;
    }

    public void register(Connection c)
    {
        connections.add(c);
    }

    public void register(Connection c, double fuel)
    {
        c.setFuelPercentage(fuel);
        connections.add(c);
    }

    public double grandTotal()
    {
        double t=0.0;
        for(Connection c : connections)
        {
            t=c.total();
        }
        return t;
    }
}