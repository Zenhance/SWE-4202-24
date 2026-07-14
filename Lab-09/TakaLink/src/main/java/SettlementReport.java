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
}
