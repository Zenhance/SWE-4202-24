import java.util.ArrayList;

public class SettlementRun {
    private ArrayList<Transaction> batch;
    private SettlementReport report;
    public SettlementRun(){
        batch = new ArrayList<>();
        report = new SettlementReport();
    }

}
