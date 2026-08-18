import java.util.ArrayList;
import java.util.List;

public class lot {
    private final List<Slot> slots;
    private final int maxstay;
    private int earned;
    private int refused;


    public lot(int bc, int rc, int lc, int maxstay) {
        this.maxstay=maxstay;
        this.earned=0;
        this.refused=0;
        this.slots= new ArrayList<Slot>();
        for(int i=0;i<bc;i++){
            slots.add(new Slot(slottype.BIKE));
        }
        for(int i=0;i<bc;i++){
            slots.add(new Slot(slottype.CAR));
        }
        for(int i=0;i<bc;i++){
            slots.add(new Slot(slottype.TRUCK));
        }

    }

}
