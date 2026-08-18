import javax.swing.tree.VariableHeightLayoutCache;
import java.util.concurrent.TimeUnit;

public enum Slot {
    BIKE(10,5,0),

    REGULAR(30 ,20, 15),
    LARGE(50, 40, 25);

    private final int firstHour;
    private final int furtherHour;
    private final int subCharge;

    Slot(int firstHour,int furtherHour,int subCharge){
        this.firstHour =firstHour;
        this.furtherHour=furtherHour;
        this.subCharge=subCharge;

    }


    public int getFirstHour() {
        return firstHour;
    }

    public int getFurtherHour() {
        return furtherHour;
    }

    public int getSubCharge() {
        return subCharge;
    }

}
