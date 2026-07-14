import java.util.ArrayList;
import java.util.List;

public class SettlementRun {

    List<Transaction> batch = new ArrayList<>();

    public void submit(Transaction t) {
    }

    public void submit(Transaction t, int times){

    }

    public SettlementReport settle() {
        return new SettlementReport();
    }

    public int pending() {
        return 0;
    }
}
