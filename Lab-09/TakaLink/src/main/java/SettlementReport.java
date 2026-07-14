public class SettlementReport {
    private int settledTransactions;
    private int rejectedTransactions;

    public int settledCount(){
        return settledTransactions;
    }

    public int rejectedCount(){
        return rejectedTransactions;
    }

    public double totalMoved(){
        return 0.0;
    }

    public double totalFees(){
        return 0.0;
    }

    public Object errorOf(Transaction bad){
        return bad;
    }

    public boolean isSettled(Transaction t){
        return false;
    }


}


