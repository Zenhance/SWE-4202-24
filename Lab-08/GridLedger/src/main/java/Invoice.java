public class Invoice {
    private Connection connection;
    public Invoice(Connection connection){
        this.connection=connection;
    }
    public double getAmount(){
        return connection.total();
    }
}
