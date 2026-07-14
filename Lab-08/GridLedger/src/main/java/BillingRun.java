import java.util.ArrayList;
import java.util.List;
public class BillingRun {
    private final List<Connection> connections=new ArrayList<>();

    void register(Connection connection){
        connections.add(connection);
    }

    void register(Connection connection, double fuelpercent){
        connection.setFuelDefault(fuelpercent);
        connections.add(connection);
    }
    int size(){
        return connections.size();
    }



    public List<BillingRun> execute(){

        return null;
    }
    double grandTotal() {
        double sum = 0;
        for (Connection connection : connections) {
            sum += connection.total();
        }
        return sum;
    }


    public double getTotal() {
        return grandTotal();
    }
}
