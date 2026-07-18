import java.util.ArrayList;

public class SettlementReport {
    private int settledTransactions;
    private int rejectedTransactions;

    private ArrayList<Transaction> settledList;
    private ArrayList<Transaction> rejectedList;
    private ArrayList<TransactionException> rejectedExceptions;

    public SettlementReport(int settledTransactions, int rejectedTransactions,
                            ArrayList<Transaction> settledList,
                            ArrayList<Transaction> rejectedList,
                            ArrayList<TransactionException> rejectedExceptions) {
        this.settledTransactions = settledTransactions;
        this.rejectedTransactions = rejectedTransactions;
        this.settledList  = settledList;
        this.rejectedList = rejectedList;
        this.rejectedExceptions = rejectedExceptions;
    }

    public int settledCount() {
        return settledTransactions;
    }

    public int rejectedCount() {
        return rejectedTransactions;
    }

    public void recordSettled(Transaction t) {
        settledTransactions++;
        settledList.add(t);
    }
    
    public double totalMoved() {
        double moved = 0;
        for (Transaction t : settledList ) {
            moved  += t.getAmount();
        }

        return moved;
    }

    public double totalFees() {
        double fees = 0;
        for (Transaction t: settledList ) {
            fees += t.fee();
        }

        return fees;
    }

    public TransactionException errorOf(Transaction t) {
        // for each loop is not used, because we have to match rejectedList with rejectedErrors
        for (int i = 0; i < rejectedList.size(); i++) {
            if (rejectedList.get(i) == t)
                return rejectedExceptions.get(i);
        }
        return null;
    }

    public boolean isSettled(Transaction transaction) {
        for (Transaction t: settledList) {
            if (t == transaction) {
                return true;
            }
        }
        return false;
    }
}
