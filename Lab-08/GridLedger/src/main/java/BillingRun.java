import java.util.ArrayList;
import java.util.List;

public class BillingRun {
    private final List<Connection> connections = new ArrayList<>();
    public void register(Connection connection) {
        connections.add(connection);
    }

    public void register(Connection connection, double fuelPercentage) {
        connection.setFuelPercentage(fuelPercentage);
        connections.add(connection);
    }

    public List<Invoice> execute() {
        List<Invoice> invoices = new ArrayList<>();
        for (Connection connection : connections) {
            invoices.add(new Invoice(connection));
        }
        return invoices;
    }
    public double grandTotal() {
        double sum = 0.0;
        for (Connection connection : connections) {
            sum += connection.total();
        }
        return sum;
    }

    public int size() {
        return connections.size();
    }
}
