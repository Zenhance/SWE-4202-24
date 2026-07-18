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
        int size = transactions.size();
        int rejectedTransactions = 0;
        int settledTransactions = 0;
        String message = "";
        ArrayList<Transaction> settledList = new ArrayList<>();
        ArrayList<Transaction> rejectedList = new ArrayList<>();
        ArrayList<TransactionException> rejectedExceptions = new ArrayList<>();

        for (Transaction t : transactions) {
            try {
                t.settle();
                settledTransactions++;
                settledList.add(t);
            } catch (TransactionException e) {
                rejectedTransactions++;
                rejectedList.add(t);
                rejectedExceptions.add(e);
                message = message.concat(e.getMessage());
                message = message.concat("\n");
            }
        }

        //int settledTransactions = size - rejectedTransactions;

        return new SettlementReport(message, settledTransactions, rejectedTransactions,
                settledList, rejectedList, rejectedExceptions);
    }
}
