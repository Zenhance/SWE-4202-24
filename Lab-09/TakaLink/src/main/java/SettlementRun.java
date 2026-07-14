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
    }

    public int pending() {
        return transactions.size();
    }
}
