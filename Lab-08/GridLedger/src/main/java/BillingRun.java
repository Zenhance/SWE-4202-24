import java.util.ArrayList;


public class BillingRun{
    private ArrayList<Connection>connections;
    public BillingRun(){
        connections=new ArrayList<>();
    }
    public void register(Connection c){
        connections.add(c);
    }
    public void register(Connection c,double fuelPercentage){
        connections.add(c);
    }
    public int size(){
        return connections.size();
    }
    public ArrayList<Invoice> execute(){
        ArrayList<Invoice> invoices=new ArrayList<>();
        for(Connection c:connections){
            invoices.add(new Invoice(c));
        }
        return invoices;
    }

    public double grandTotal(){
        double total=0;
        for(Connection c:connections){
            total+=c.total();
        }
        return total;
    }
}