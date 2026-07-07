package main.java;

public class Invoice {
    private final Connection connection;
    private final double total;

    public Invoice(Connection connection){
        if(connection==null){
            throw new IllegalArgumentException("Invoice must be a connection");
        }
        this.connection=connection;
        this.total=connection.total();
    }
    public Connection connection(){
        return connection;
    }
    public double total(){
        return total;
    }
    public double getTotal(){
        return getTotal();
    }
}
