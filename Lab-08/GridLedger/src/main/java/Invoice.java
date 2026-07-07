public class Invoice {

    private Connection connection;
    Invoice(Connection connection){
        this.connection = connection;
    }

    public double getTotal(){
        return connection.total();
    }


}
