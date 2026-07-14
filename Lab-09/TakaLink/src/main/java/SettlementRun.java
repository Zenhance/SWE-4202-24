import java.util.ArrayList;

public class SettlementRun {

    private final ArrayList<Transaction> batch;

    public SettlementRun() {
        batch = new ArrayList<>();
    }

    public void submit(Transaction transaction) {
        batch.add(transaction);
    }

    public void submit(
            Transaction transaction,
            int repeatCount
    ) {
        for (int i = 0; i < repeatCount; i++) {
            batch.add(transaction);
        }
    }

    public int pending() {
        return batch.size();
    }

    public SettlementReport settle() {
        return new SettlementReport();
    }
}