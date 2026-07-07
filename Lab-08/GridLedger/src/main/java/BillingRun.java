import java.util.ArrayList;

public class BillingRun {
    private ArrayList<Connection>connections;
    public BillingRun(){
        connections=new ArrayList<>();
    }
    public void register(Connection c) {
        connections.add(c);
    }
    public void register(Connection c,double fuelPercentage){
        connections.add(c);
    }
}
