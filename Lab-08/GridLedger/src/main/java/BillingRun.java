import java.util.ArrayList;
import java.util.List;

public class BillingRun {
    private ArrayList<Connection> batch = new ArrayList<>();
    public void register(Connection c){
        batch.add(c);
    }

    public void register(Connection c, double fuelPercent){
        c.setFuelPercent(fuelPercent);
        batch.add(c);
    }

    public int size(){
        return batch.size();
    }

    public double grandTotal(){
        double total = 0;
        for (Connection c : batch){
            total += c.total();
        }
        return total;
    }

    public ArrayList<Invoice> execute(){
        ArrayList<Invoice> invoices =  new ArrayList<>();
        Invoice temp;

        for(Connection c : batch){
            temp = new Invoice(c.total());
            invoices.add(temp);
        }

        return invoices;
    }
}
