import java.util.ArrayList;
import java.util.List;

public class SlotManagement
{
    private List<Slot> bikeSlot;
    private List<Slot> regularSlot;
    private List<Slot> largeSlot;

    public SlotManagement(int bike, int regular, int large)
    {
        bikeSlot = new ArrayList<>();
        regularSlot = new ArrayList<>();
        largeSlot = new ArrayList<>();

        createSlots(bikeSlot, Slot.Type.BIKE, bike);
        createSlots(regularSlot, Slot.Type.REGULAR, regular);
        createSlots(largeSlot, Slot.Type.LARGE, large);
    }

    public Slot findFreeSlot(List<Slot> slots)
    {
        for(Slot slot : slots)
        {
            if(slot.isFreeSlot())
            {
                return slot;
            }
        }
        return null;
    }

    private void createSlots(List<Slot> slots, Slot.Type type, int count)
    {
        for(int i=0;i<count;i++)
        {
            slots.add(new Slot(type));
        }
    }

    public Slot findSlot(Vehicle.Category category)
    {
        if(category==Vehicle.Category.BIKE)
        {
            Slot slot=findFreeSlot(bikeSlot);
            if(slot!=null)
            {
                return slot;
            }
            slot=findFreeSlot(regularSlot);
            if(slot!=null)
            {
                return slot;
            }
            return findFreeSlot(largeSlot);
        }
        if(category==Vehicle.Category.CAR)
        {
            Slot slot=findFreeSlot(regularSlot);
            if(slot!=null)
            {
                return slot;
            }
            return findFreeSlot(largeSlot);
        }
        return findFreeSlot(largeSlot);
    }

    public int countFreeSlot(Slot.Type type)
    {
        List<Slot> slots = getSlots(type);
        int slotCount=0;
        for(Slot slot : slots)
        {
            if(slot.isFreeSlot())
            {
                slotCount++;
            }
        }
        return slotCount;
    }

    private List<Slot> getSlots(Slot.Type type)
    {
        if(type==Slot.Type.BIKE)
        {
            return bikeSlot;
        }
        if(type==Slot.Type.REGULAR)
        {
            return regularSlot;
        }
        return largeSlot;
    }
}