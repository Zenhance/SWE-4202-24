import java.util.ArrayList;

public class ParkingLot {
    ArrayList<Slot> slots = new ArrayList<Slot>();
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    int maxStay;
    int earned;
    int refused;

    public ParkingLot(int bike, int regular, int large){
        earned=0;
        refused=0;

        for(int i=0;i<bike;i++){
            slots.add(new Slot(SlotType.BIKE));
        }

        for(int i=0;i<regular;i++){
            slots.add(new Slot(SlotType.REGULAR));
        }

        for(int i=0;i<large;i++){
            slots.add(new Slot(SlotType.LARGE));
        }
    }

    public void setMaxStay(int x){
        maxStay=x;
    }
}
