public class BillingRun {

    private ArrayList<Connection> connections;
    private ArrayList<Invoice> invoices;

    public BillingRun(){

        connections=new ArrayList<>(); invoices=new ArrayList<>();
    }

    public void register(Connection c){
        connections.add(c);
        invoices.add(new Invoice(c));
    }


    public void register(Connection c,double fuelRate){
        connections.add(c);
        invoices.add(Invoice(c));
    }

    public int size(){

        return connections.size;
    }




    public ArrayList<Invoice> execute() {
        return invoices;
    }
}