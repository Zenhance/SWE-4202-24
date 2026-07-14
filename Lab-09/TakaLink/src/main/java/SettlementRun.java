public class SettlementRun {
    public void submit(Transaction good1) {
    }
    public void submit(Transaction good1,int a) {
    }

    public int pending() {
        return 5;
    }

    public SettlementReport settle() {
        SettlementReport report = new SettlementReport();
        return report;
    }
}
