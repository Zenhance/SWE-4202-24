import java.util.ArrayList;
import java.util.List;
public class BillingRun {
    private final List<Connection> batch=new ArrayList<>();
    public void register(Connection c){
        batch.add(c);
    }
    public void register(Connection c,double fuelPercent) {
        c.setFuelPercentage(fuelPercent);
        batch.add(c);
    }
        public int size(){
            return batch.size();
        }
        public double grandTotal(){
            double sum=0;
            for(Connection c:batch){
                sum+=c.total();
            }
            return sum;
        }
        public List<Invoice> execute(){
            List<Invoice> invoices=new ArrayList<>();
            for(Connection c:batch){
                invoices.add(new Invoice(c.total()));
            }
            return invoices;
        }
    }
