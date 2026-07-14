public class SettlementRun {

    int count = 0;

    public void submit(Transaction s, int n){count += n;}

    public void submit(Transaction s){count++;}


    public SettlementReport settle(){return null;}


    public int pending(){return count;}
}
