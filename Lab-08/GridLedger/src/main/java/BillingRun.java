import java.util.ArrayList;
import java.util.List;

public class BillingRun {

    private List<Connection> connections;

    public BillingRun() {
        connections = new ArrayList<>();
    }


    public void register(Connection connection) {
        connections.add(connection);
    }



    public int size() {
        return connections.size();
    }


    public double grandTotal() {
        double total = 0;

        for (Connection connection : connections) {
            total += connection.total();
        }

        return total;
    }


    public List<Invoice> execute() {

        List<Invoice> invoices = new ArrayList<>();

        for (Connection connection : connections) {
            invoices.add(new Invoice(connection.total()));
        }

        return invoices;
    }
}