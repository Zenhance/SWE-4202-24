import java.util.ArrayList;
import java.util.List;

public class SlotManagement {

    private List<Slot> bikeSlots;
    private List<Slot> regularSlots;
    private List<Slot> largeSlots;

    public SlotManagement(int bike, int regular, int large){
        bikeSlots=new ArrayList<>();
        regularSlots=new ArrayList<>();
        largeSlots=new ArrayList<>();
    }
}
