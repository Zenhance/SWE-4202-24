import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettlementRun {
    private final List<Transaction> batch = new ArrayList<>();

    public void submit(Transaction t) { batch.add(t); }

    public void submit(Transaction t, int count) {
        if (count <= 0) throw new IllegalArgumentException("count must be positive");
        for (int i = 0; i < count; i++) batch.add(t);
    }

    public int pending() { return batch.size(); }
    public SettlementReport settle() {
        List<Transaction> settled = new ArrayList<>();
        Map<Transaction, TransactionException> rejected = new HashMap<>();
        double totalMoved = 0.0;
        double totalFees = 0.0;

        for (Transaction t : batch) {
            try {
                t.settle();
                settled.add(t);
                totalMoved += t.amount;
                totalFees += t.fee();
            } catch (TransactionException e) {
                rejected.put(t, e);
            }
        }
        return new SettlementReport(settled, rejected, totalMoved, totalFees);
    }
}
