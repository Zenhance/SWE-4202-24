public class BillingRun
{
private Arraylist<Connection> connections;
private static final double FUEL_DEFAULT = 0.20;
public BillingRun()
{
    connections = new ArrayList<>();

}
public void register (Connection connection)
{
    connections.add(connection);

}
public void register (Connection connection, double fuel)
{
    connections.add(connection);
    fuel=FUEL_DEFAULT;
}
public int size()
{
    return connections.size();
}

public double grandTotal()
{
    double total=0;
    for (Connection c:connections)
    {
        total +=c.total();
    }
    return total;
}
public List <Invoice> execute()
{
List<Invoice> invoices= new ArrayList<>();
for (Connection c:connections)
{
    invoices.add(new Invoice(c));
}
return invoices;
}





}