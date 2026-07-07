public class Invoice {
    private final Connection connection;
    private final double total;

    public Invoice(Connection connection){
        this.connection = connection;
        this.total = connection.total();
    }
    public Connection getConnection(){
        return connection;
    }
    public double getTotal(){
        return total;
    }
}
