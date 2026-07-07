import java.util.ArrayList;
import java.util.List;

public class BillingRun {
    private final List<Connection> connections = new ArrayList<>();
    public void register(Connection connection) {
        connections.add(connection);
    }

    public void register(Connection connection, double fuelSurchargePercentage) {
        connection.setFuelSurchargePercentage(fuelSurchargePercentage);
        connections.add(connection);
    }

    public int size() {
        return connections.size();
    }

    public double grandTotal() {
        double totalSum = 0.0;
        for (Connection c : connections) {
            totalSum += c.total();
        }
        return totalSum;
    }
}