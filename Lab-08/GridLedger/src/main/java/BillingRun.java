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
}
