import java.util.ArrayList;
import java.util.List;

public class BillingRun {
    private List<Connection> connections;

    public void register(Connection c) {
        connections.add(c);
    }

    public void register(Connection c, double fuelPercent){
        c.setFuelPercent(fuelPercent);
        connections.add(c);
    }

    public int size(){
        return connections.size();
    }

    public double grandTotal(){
        double total = 0.0;
        for(Connection c : connections){
            total+=c.total();
        }
        return total;
    }

    public List<Invoice> execute(){
        List<Invoice> invoices = new ArrayList<>();
        for(Connection connection : connections){
            invoices.add(new Invoice(connection));
        }
        return invoices;
    }
}
