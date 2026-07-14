import java.util.ArrayList;
import java.util.List;

public class BillingRun {
    ArrayList<Connection> connections;
    public void register(Connection c) {
        connections.add(c);
    }

    public List<Invoice> execute() {
        List<Invoice> invoices = new ArrayList<>();
        int i=0;
        while(connections.size()>i){
            invoices.add(new Invoice(connections.get(i)))
            i++;
        }
        return invoices;
    }

    public double grandTotal() {
        double total=0;
        int i=0;
        while(connections.size()> i) {
            total+=connections.get(i).total();
            i++;
        }
        return total;
    }


    public int size() {
        return connections.size();
    }
}
