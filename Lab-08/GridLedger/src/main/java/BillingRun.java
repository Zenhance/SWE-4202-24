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
}
