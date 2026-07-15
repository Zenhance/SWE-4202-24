import java.util.ArrayList;

public class SettlementReport
{
    private int settledCount;
    private int rejectedCount;
    private double totalMoved;
    private double totalFees;

    private ArrayList<Transaction> settledTransaction;
    private ArrayList<Transaction> failedTransactions;
    private ArrayList<Transaction> failureReasons;

    public SettlementReport()
    {
        settledTransaction = new ArrayList<>();
        failedTransactions = new ArrayList<>();
        failureReasons = new ArrayList<>();
    }

    public void addSuccess(Transaction t)
    {
        settledCount++;
        totalMoved=totalMoved+t.getAmount();
        totalFees=totalFees+t.fee();
        settledTransaction.add(t);
    }
}