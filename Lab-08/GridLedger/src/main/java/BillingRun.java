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

    public int size(){
        return connections.size();
    }

    public double grandTotal(){
        double sum = 0.0;
        for(Connection c : connections){
            sum += c.total();
        }
        return sum;
    }
}
