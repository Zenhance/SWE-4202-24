public class SettlementReport {

    public SettlementReport() {
    }

    public int settledCount() {
        return 0;
    }

    public int rejectedCount() {
        return 0;
    }

    public double totalMoved() {
        return 0.0;
    }

    public double totalFees() {
        return 0.0;
    }

    public TransactionException errorOf(
            Transaction transaction
    ) {
        return null;
    }

    public boolean isSettled(
            Transaction transaction
    ) {
        return false;
    }
}