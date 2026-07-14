import java.util.ArrayList;
import java.util.Objects;

public class SettlementRun {
    private ArrayList<Transaction> batch;

    public SettlementRun() {
        batch=new ArrayList<>();
    }

    public void submit(Transaction t){

    }
    public void submit(Transaction t, int c){

    }

    public int pending(){
        return 0;
    }

    public SettlementReport settle(){
        return null;
    }


}