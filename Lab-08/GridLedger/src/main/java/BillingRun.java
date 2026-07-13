import java.util.*;
import java.util.ArrayList;

public class BillingRun {
    private final List<Connection> connections = new ArrayList<>();

    public void register(Connection c){
        connections.add(c);
    }

    public void register(Connection c, double fuelPet){
        c.setFuelPet(fuelPet);
        connections.add(c);
    }

    public int size(){
        return connections.size();
    }

    public double grandTotal(){
        double sum=0;

        for (Connection c : connections){
            sum += c.total();
        }
        return sum;
    }

    public List<Invoice> execute()
    {
        List<Invoice> invoices = new ArrayList<>();
        for(Connection c : connections) {
            invoices.add(new Invoice(c.total()));
        }
        return invoices;
    }

}
