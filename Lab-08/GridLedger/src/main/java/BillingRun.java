import java.util.ArrayList;

public class BillingRun {

    private ArrayList<Connection> connections;
    private ArrayList<Invoice> invoices;

    public BillingRun() {
        connections = new ArrayList<>();
        invoices = new ArrayList<>();
    }

    public void register(Connection c) {
        connections.add(c);
    }

    public void register(Connection c, double fuelRate) {
        connections.add(c);
    }


    public int size(){
        return connections.size();
    }

    public double grandTotal() {
        double subtotal = 0;
        for (Connection c : connections) {
            subtotal += c.total();
        }
        return subtotal;
    }

    public ArrayList<Invoice> execute() {

        return invoices;
    }
}