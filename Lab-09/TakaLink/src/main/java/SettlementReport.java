public class SettlementReport {
    int settlementId;
    public SettlementReport() {
    }

    public int settledCount() {
    return 0;
    }

    public int rejectedCount() {
        return 0;
    }

    public double totalMoved() {
        return 0;
    }

    public double totalFees() {
        return 0;
    }

    public Exception errorOf(Transaction bad2) {
        return null;
    }

    public boolean isSettled(Transaction good1) throws InsufficientBalanceException, FrozenAccountException, InvalidPinException, DailyLimitExceededException
        {
            return true;}


}
