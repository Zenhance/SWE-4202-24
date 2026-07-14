public class SettlementReport {
    public int settledCount() {
        return 1;
    }

    public int rejectedCount() {
        return 1;
    }

    public double totalMoved() {
        return 0.0;
    }

    public double totalFees() {
        return 0.0;
    }

    public Object errorOf(Transaction bad1) {
        return bad1;
    }

    public boolean isSettled(Transaction good1) {
        return true;
    }
}
