import java.util.ArrayList;

public class SettlementReport {
    private int settledTransactions;
    private int rejectedTransactions;
    private String reportMessage;

    private ArrayList<Transaction> settledList;
    private ArrayList<Transaction> rejectedList;
    private ArrayList<TransactionException> rejectedExceptions;

    public SettlementReport(String reportMessage, int settledTransactions, int rejectedTransactions,
                            ArrayList<Transaction> goodTransactions,
                            ArrayList<Transaction> rejectedList,
                            ArrayList<TransactionException> rejectedExceptions) {
        this.reportMessage = reportMessage;
        this.settledTransactions = settledTransactions;
        this.rejectedTransactions = rejectedTransactions;
        this.settledList  = goodTransactions;
        this.rejectedList = rejectedList;
        this.rejectedExceptions = rejectedExceptions;
    }

    public int settledCount() {
        return settledTransactions;
    }

    public int rejectedCount() {
        return rejectedTransactions;
    }

    public double totalMoved() {
        double moved = 0;
        for (Transaction t : settledList ) {
            moved  += t.getAmount();
        }

        return moved;
    }

    public double totalFees() {
        double fees = 0;
        for (Transaction t: settledList ) {
            fees += t.fee();
        }

        return fees;
    }

    public Object errorOf(Transaction bad1) {
        return bad1;
    }

    public boolean isSettled(Transaction t) {
        return false;
    }

//    public void errorOf(Transaction t) throws TransactionException{
//        try {
//            PersonalWallet p1 = new PersonalWallet("", 0.0, "");
//            PersonalWallet p2 = new PersonalWallet("", 0.0, "");
//            Payment p = new Payment(p1, p2, 0.0, "");
//            throw new InsufficientBalanceException("Invalid");
//        }
//        catch (TransactionException e) {
//            System.out.println("Invalid");
//        }
//    }
}
