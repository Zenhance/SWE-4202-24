import java.util.ArrayList;

public class SettlementReport {
    private int settledTransactions;
    private int rejectedTransactions;

    private ArrayList<Transaction> settledList;
    private ArrayList<Transaction> rejectedList;
    private ArrayList<TransactionException> rejectedExceptions;

    public SettlementReport() {
        this.settledTransactions = 0;
        this.rejectedTransactions = 0;
        this.settledList  = new ArrayList<>();
        this.rejectedList = new ArrayList<>();
        this.rejectedExceptions = new ArrayList<>();
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

    public void recordRejected(Transaction t, TransactionException e) {
        rejectedTransactions++;
        rejectedList.add(t);
        rejectedExceptions.add(e);
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
