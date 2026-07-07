import java.util.ArrayList;
import java.util.List;

public class BillingRun{

    List<Connection> connections = new ArrayList<>(); //just found out how List works :0
    List<Invoice> invoices = new ArrayList<>();


    public List<Invoice> execute(){
        for(Connection c: connections){
            Invoice e = new Invoice(c);
            invoices.add(e);
        }
        return invoices;
    }

    public int size(){return connections.size();}

    public double grandTotal(){
        double grand = 0.0;
        for(Connection c : connections){
            grand += c.total();
        }
        return grand;
    }

    public void register(Connection connection){
        connections.add(connection);
    }

    public void register(Connection connection, double d){
        connection.fuelPercent = d;
        connections.add(connection);
    }






}