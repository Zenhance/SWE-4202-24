import java.util.ArrayList;
import java.util.List;
public class BillingRun {
    private ArrayList<Connection> connections= new ArrayList<>();
    public void register(Connection c){
      connections.add(c);
    }
    public void register(Connection c, double fuel){
        c.setFuelPercentage(fuel);
        connections.add(c);
    }
}
