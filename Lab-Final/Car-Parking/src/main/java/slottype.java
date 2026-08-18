import java.util.ArrayList;
import java.util.List;

public class slottype {
    private vehicles vehicle;
    private int bsc;

    public void setBsc(int count) {
        this.bsc = count;
    }

    public int getBsc() {
        return this.bsc;
    }

    List<vehicles>check= new ArrayList<>();
    public void add(vehicles v){
        check.add(v);

    }
}
