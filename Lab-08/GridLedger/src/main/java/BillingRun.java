import java.util.ArrayList;

public class BillingRun {

    private ArrayList<Connection> connections= new ArrayList<Connection>();
    public void register(Connection c){
            connections.add(c);
    }
    public void register(Connection c, double d){
            c.setFuelSurcharge(d);
            connections.add(c);
    }

    public int size(){
        return connections.size();
    }

    public double grandTotal(){
        double total =0;
        for(Connection c: connections){
            total+=c.total();
        }
        return total;
    }
    public ArrayList<Invoice> execute(){
        ArrayList<Invoice> invoices= new ArrayList<>() ;
        Invoice temp;
        for(Connection c:connections){
            temp=new Invoice(c.total());
            invoices.add(temp);
        }
        return invoices;
    }




}
