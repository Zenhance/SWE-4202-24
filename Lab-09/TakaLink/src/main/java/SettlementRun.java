import java.util.ArrayList;

public class SettlementRun {

    ArrayList<Transaction> trans = new ArrayList<>();
        // add() -> adds to the end of the array.
        // for (int i = trans.size; i > 0; i--)
            // trans[i].settle();
            // trans.remove(i);

        // am i boring you
            // then you should take rest TwT
            // but you are hurting TwT

    int settled = 0;
    int rejected = 0;
    int pending = 0;

    public void submit(Transaction s, int n){
        for(int i = 0; i < 3; i++) {
            trans.add(s);
            pending++;
        }
    }

    public void submit(Transaction s){
        trans.add(s);
    }

    public SettlementReport settle(){
        SettlementReport r = new SettlementReport();

        for (Transaction t: trans) {
            try {
                t.settle();
            } catch (Exception e) {
                rejected++;
                continue;
            }
            settled++;
        }
        return r;
    }


    public int pending(){return trans.size();}
}
