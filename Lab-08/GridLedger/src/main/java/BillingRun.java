import java.util.ArrayList;
import java.util.List;

public class BillingRun {
    private final List<Connection> batch=new ArrayList<>();
    public void register(Connection c) {
        batch.add(c);
    }
    public int size(){
        return batch.size();
    }

    public void register(Connection res, double v) {
    }

    public double grandTotal() {
        return 0;
    }

    public List<Invoice> execute() {
        return null;
    }
}
