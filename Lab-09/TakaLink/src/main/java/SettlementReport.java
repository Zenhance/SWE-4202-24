import java.util.ArrayList;
import java.util.List;

public class SettlementReport {
    List<Transaction> settledTransactions = new ArrayList<>();
    List<Transaction> rejectedTransactions = new ArrayList<>();


    public int settledCount() {
        return settledTransactions.size();
    }
    public int  rejectedCount() {
        return rejectedTransactions.size();
    }
    public boolean isSettled(Transaction transaction) {
        return settledTransactions.contains(transaction);
    }

    public Object errorOf(Transaction bad1) {
        return bad1;
    }

    public double totalMoved() {
        return 0.0;
    }

    public double totalFees() {
        return 0.0;
    }
}
