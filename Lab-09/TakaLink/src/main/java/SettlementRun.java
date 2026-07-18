import java.util.ArrayList;

public class SettlementRun {
    private ArrayList<Transaction> transactions;

    public SettlementRun() {
        transactions = new ArrayList<>();
    }
    public void submit(Transaction transaction) {
        transactions.add(transaction);
    }

    public void submit(Transaction transaction, int amount) {
        for (int i = 0; i < amount; i++) {
            transactions.add(transaction);
        }
    }

    public int pending() {
        return transactions.size();
    }

    public SettlementReport settle() {
        SettlementReport report = new SettlementReport();

        for (Transaction t : transactions) {
            try {
                t.settle();
                report.recordSettled(t);
            } catch (TransactionException e) {
                report.recordRejected(t, e);
            }
        }

        return report;
    }
}
