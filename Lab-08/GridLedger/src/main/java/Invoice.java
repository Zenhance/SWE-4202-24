public class Invoice {
    private final Connection connection;

    public Invoice(Connection c){
        connection = c;
    }

    public double getTotal(){
        return connection.total();
    }
}