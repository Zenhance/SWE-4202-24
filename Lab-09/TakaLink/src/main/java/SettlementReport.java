import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SettlementReport {
    private final List<Transaction> settled;
    private final Map<Transaction, TransactionException> rejected;
    private final double totalMoved;
    private final double totalFees;

    public SettlementReport(List<Transaction> settled, Map<Transaction, TransactionException> rejected,
                            double totalMoved, double totalFees) {
        this.settled = Collections.unmodifiableList(settled);
        this.rejected = Collections.unmodifiableMap(rejected);
        this.totalMoved = totalMoved;
        this.totalFees = totalFees;
    }

    public int settledCount() { return settled.size(); }
    public int rejectedCount() { return rejected.size(); }
    public double totalMoved() { return totalMoved; }
    public double totalFees() { return totalFees; }

    public TransactionException errorOf(Transaction t) { return rejected.get(t); }
    public boolean isSettled(Transaction t) { return settled.contains(t); }
}
