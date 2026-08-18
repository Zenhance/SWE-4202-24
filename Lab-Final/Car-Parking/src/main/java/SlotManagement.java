import java.util.ArrayList;
import java.util.List;

public class SlotManagement {
    private List<Slot> bikeSlots;
    private List<Slot> regularSlots;
    private List<Slot> largeSlots;

    public SlotManagement(int bike,int regular,int large){
        bikeSlots=new ArrayList<>();
        regularSlots=new ArrayList<>();
        largeSlots=new ArrayList<>();

        createSlots(bikeSlots,Slot.Type.BIKE,bike);
        createSlots(regularSlots,Slot.Type.REGULAR,regular);
        createSlots(largeSlots,Slot.Type.LARGE,large);
    }

    public void createSlots(List<Slot> slots, Slot.Type type, int count) {
        for (int i = 0; i < count; i++) {
            slots.add(new Slot(type));
        }
    }

        public Slot findFreeSlot(List<Slot> slots){
        for(Slot s:slots){
            if(s.isFree()){
                return s;
            }
        }
        return null;
    }

    public Slot findSlot(Vehicle.Type type) {

        if (type == Vehicle.Type.BIKE) {

            Slot slot = findFreeSlot(bikeSlots);

            if (slot != null) {
                return slot;
            }

            slot = findFreeSlot(regularSlots);

            if (slot != null) {
                return slot;
            }

            return findFreeSlot(largeSlots);
        }

        if (type == Vehicle.Type.CAR) {

            Slot slot = findFreeSlot(regularSlots);

            if (slot != null) {
                return slot;
            }

            return findFreeSlot(largeSlots);
        }

        return findFreeSlot(largeSlots);
    }

    public List<Slot> getSlots(Slot.Type type)
    {
        if(type==Slot.Type.BIKE)
        {
            return bikeSlots;
        }
        if(type==Slot.Type.REGULAR)
        {
            return regularSlots;
        }
        return largeSlots;
    }

    public int countFreeSlot(Slot.Type type)
    {
        List<Slot> slots = getSlots(type);
        int slotCount=0;
        for(Slot slot : slots)
        {
            if(slot.isFree())
            {
                slotCount++;
            }
        }
        return slotCount;
    }



}
