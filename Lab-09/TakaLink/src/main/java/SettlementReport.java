import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Map;
public class SettlementReport {

    public int settledCount(){
        return 0;
    }
    public int rejectedCount(){
        return 0;
    }
    public double totalMoved(){
        return 0.0;
    }
    public double totalFees(){
        return 0.0;
    }
    public TransactionException errorOf(Transaction t){
        return null;
    }
    public boolean isSettled(Transaction t){
        return false;
    }
    void recordSettled(Transaction t){
    }
    void recordRejected(Transaction t, TransactionException e){
    }
}
