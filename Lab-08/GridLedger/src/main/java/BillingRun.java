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
}