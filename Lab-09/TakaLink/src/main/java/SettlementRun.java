import java.util.ArrayList;
import java.util.List;

public class SettlementRun {
    List<Transaction> transactions = new ArrayList<Transaction>();


    public void submit(Transaction transaction) {
        transactions.add(transaction);
    }

}
