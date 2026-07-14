import java.util.ArrayList;

public class SettlementReport {
    private int settledCount;
    private int rejectedCount;
    private double totalValueMoved;
    private double totalFees;
    private ArrayList<String> rejectedReasons;
    public SettlementReport(){
        rejectedReasons = new ArrayList<>();
    }

    public void addSuccess(Transaction t){
        settledCount++;
        totalValueMoved += t.getAmount();
        totalFees+= t.getFee();
    }
    public void addFailure(Transaction t, TransactionException e){
        rejectedCount++;
        rejectedReasons.add(t.getType() + " : " + e.getMessage());
    }
}
