import java.util.ArrayList;

public class SettlementRun {
    private ArrayList<Transaction> transactions;
    private SettlementReport report;

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

    public SettlementReport settle() throws TransactionException {
        int size = this.pending();

        for (Transaction t : transactions) {
            t.settle();
        }
        return new SettlementReport();
    }
}
