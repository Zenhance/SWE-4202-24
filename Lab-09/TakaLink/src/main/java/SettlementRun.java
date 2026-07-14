import java.util.ArrayList;
import java.util.List;


public final class SettlementRun {

    private final ArrayList<Transaction> pending = new ArrayList<>();

    public void submit(Transaction transaction) {
        pending.add(transaction);
    }

    public void submit(Transaction transaction, int times) {
        for (int i = 0; i < times; i++) {
            pending.add(transaction);
        }
    }

    public int pending() {
        return pending.size();
    }

    public SettlementReport settle() {
        SettlementReport report = new SettlementReport();
        for (Transaction transaction : pending) {
            try {
                transaction.settle();
                report.recordSettled(transaction);
            } catch (TransactionException e) {
                report.recordRejected(transaction, e);
            }
        }
        return report;
    }
}