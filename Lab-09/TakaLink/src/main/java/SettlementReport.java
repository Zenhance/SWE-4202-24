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
}
