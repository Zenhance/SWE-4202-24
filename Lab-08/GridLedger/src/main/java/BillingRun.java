import java.util.ArrayList;
import java.util.List;

public class BillingRun {

    private ArrayList<Connection> run;

    public BillingRun(){

        this.run= new ArrayList<>();
    }

    public void register(Connection c){
        run.add(c);

    }

    public void register(Connection c, double fuelPercent){
       // c.setfuelPercent(fuelPercent);
        run.add(c);
    }

    public int size(){
        return run.size();
    }

    public double grandTotal(){
        double total=0;
        for(Connection c: run){
            total+=c.total();
        }
        return total;
    }

    public List<Invoice> execute(){
        ArrayList<Invoice> invoices= new ArrayList<>();

        for(Connection c: run){
            Invoice invoice = new Invoice(c.total());
            invoices.add(invoice);
        }
        return invoices;
    }


}
