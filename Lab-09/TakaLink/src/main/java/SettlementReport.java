import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.security.PublicKey;
import java.util.ArrayList;

public class SettlementReport {
    private int settledCount;
    private int rejectedCount;
    private double totalValueMoved;
    private double totalFees;
    private ArrayList<String> rejectedReasons;
    public SettlementReport(){
        rejectedReasons = new ArrayList<>();
    }

    public void addSuccess(Transaction t){
        settledCount++;
        totalValueMoved += t.getAmount();
        totalFees+= t.getFee();
    }
    public void addFailure(Transaction t, TransactionException e){
        rejectedCount++;
        rejectedReasons.add(t.getType() + " : " + e.getMessage());
    }
    public void printReport(){
        System.out.println("========== REPORT ===========");
        System.out.println("Settled Transactions: ");
        System.out.println("Rejected Transactions: ");
        System.out.println("Total Value Moved : " + totalValueMoved);
        System.out.println("Total Fees : " + totalFees);
        System.out.println();
        System.out.println("Rejected Reasons");
        for(String s : rejectedReasons)
            System.out.println(s);
    }
}
