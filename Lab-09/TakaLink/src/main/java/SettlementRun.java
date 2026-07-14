import java.util.ArrayList;

public class SettlementRun {
    private ArrayList<Transaction> batch;
    private SettlementReport report;
    public SettlementRun(){
        batch = new ArrayList<>();
        report = new SettlementReport();
    }
   public void addTransaction(Transaction t){
        batch.add(t);
   }
   public void addTransaction(Transaction t, int repeat){
        for(int i=0;i<repeat;i++)
            batch.add(t);
   }
   public int getWaitingCount(){
        return batch.size();
   }

    public SettlementReport execute(){
        for(Transaction t: batch){
            try{
                t.settle();
                report.addSuccess(t);

            }
            catch(TransactionException e){
                report.addFailure(t,e);
            }

            }
        return report;
        }
}
