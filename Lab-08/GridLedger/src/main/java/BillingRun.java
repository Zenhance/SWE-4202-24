import java.util.ArrayList;
import java.util.List;

public class BillingRun {
    private final List<Connection> connections = new ArrayList<>();

    public void register(Connection connection){
        connections.add(connection);
    }
    public void register(Connection connection, double fuelPercent){
        connection.setFuelPercent(fuelPercent);
        connections.add(connection);
    }
    public int size(){
        return connections.size();
    }
    public List<Invoice> execute(){
        List<Invoice> invoices = new ArrayList<>();

        for(Connection connection: connections){
            invoices.add(new Invoice(connection));
        }
        return invoices;
    }
    public double grandTotal(){
        double total = 0.0;
        for(Connection connection: connections){
            total+=connection.total();
        }
        return total;
    }
}
