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
}