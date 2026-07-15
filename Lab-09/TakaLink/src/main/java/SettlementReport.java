import java.util.ArrayList;

public class SettlementReport
{
    private int settledCount;
    private int rejectedCount;
    private double totalMoved;
    private double totalFees;

    private ArrayList<Transaction> settledTransaction;
    private ArrayList<Transaction> failedTransactions;
    private ArrayList<TransactionException> failureReasons;

    public SettlementReport()
    {
        settledTransaction = new ArrayList<>();
        failedTransactions = new ArrayList<>();
        failureReasons = new ArrayList<>();
    }

    public void addSuccess(Transaction t)
    {
        settledCount++;
        totalMoved=totalMoved+t.amount();
        totalFees=totalFees+t.fee();
        settledTransaction.add(t);
    }

    public void addFailure(Transaction t, TransactionException e)
    {
        rejectedCount++;
        failedTransactions.add(t);
        failureReasons.add(e);
    }

    public int settledCount()
    {
        return settledCount;
    }

    public int rejectedCount()
    {
        return rejectedCount;
    }

    public double totalMoved()
    {
        return totalMoved;
    }

    public double totalFees()
    {
        return totalFees;
    }

    public boolean isSettled(Transaction t)
    {
        return settledTransaction.contains(t);
    }

}