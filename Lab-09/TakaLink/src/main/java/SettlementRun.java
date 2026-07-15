import java.util.ArrayList;

public class SettlementRun
{
    private ArrayList<Transaction> batch;

    public SettlementRun()
    {
        batch = new ArrayList<>();
    }

    public int pending()
    {
        return batch.size();
    }

    public void submit(Transaction t)
    {
        batch.add(t);
    }

    public void submit(Transaction t, int repeat)
    {
        if(repeat<=0)
            return;
        for(int i=0;i<repeat;i++)
        {
            batch.add(t);
        }
    }

    public SettlementReport settle()
    {
        SettlementReport report = new SettlementReport();
        for(Transaction t : batch)
        {
            try
            {
                t.settle();
                report.addSuccess(t);
            }
            catch (TransactionException e)
            {
                report.addFailure(t,e);
            }
        }
        return report;
    }
}