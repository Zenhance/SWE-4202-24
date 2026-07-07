import java.util.ArrayList;
import java.util.List;

public class BillingRun{

    List<Connection> connections = new ArrayList<>(); //just found out how List works :0
    List<Invoice> invoices = new ArrayList<>();


    public List<Invoice> execute(){

        return invoices;
    }



    public int size(){return connections.size();}

    public int grandTotal(){return 0;}

    public void register(Connection connection){
        connections.add(connection);
    }

    public void register(Connection connection, double d){
        connection.fuelPercent = d;
        connections.add(connection);
    }






}