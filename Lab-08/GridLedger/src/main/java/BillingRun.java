import java.util.ArrayList;
import java.util.List;

public class BillingRun {
    List<Connection> connections = new ArrayList<Connection>();

    public void register(Connection c){
        connections.add(c);
    }

    public void register(Connection c, double nfs){
        c.changeFuelSurcharge(nfs);
        connections.add(c);
    }
}
