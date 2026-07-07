public class Invoice {

    Connection c;

    public Invoice(Connection c){
        this.c = c;
    }
    public double getTotal(){ return c.total(); }

}