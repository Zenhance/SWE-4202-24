public class Invoice {
    private final double total;

    public Invoice(Connection connection) {
        this.total = connection.total();
    }

    public double getTotal() {
        return total;
    }
}
