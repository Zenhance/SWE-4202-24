import java.util.ArrayList;

public class SettlementRun {
    ArrayList<Transaction> transactions=new ArrayList<>();

    public void submit(Transaction good1) {
        transactions.add(good1);
    }

    public SettlementReport settle() throws InsufficientBalanceException, FrozenAccountException, InvalidPinException, DailyLimitExceededException {
        while(transactions.size()>0) {
            transactions.get(0).settle();
            transactions.remove(0);
        }
        return new SettlementReport();
    }

    public int pending() {
        return transactions.size();
    }

    public void submit(Transaction t, int i) {
        while(i>0){
            transactions.add(t);
            i--;
        }
    }
}
