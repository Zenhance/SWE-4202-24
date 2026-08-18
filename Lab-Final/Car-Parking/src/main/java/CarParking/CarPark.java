package CarParking;
import java.util.ArrayList;
import java.util.List;

public final  class CarPark {
    private final List<ParkingSlot>
            =new ArrayList<>();
    private final VehicleCatalogue catalogue
            =new VehicleCatalogue();
    private final int maxStay;
    private long earned=0;
    private long refused=0;
    public CarPark(int BikeCount,int RegularCount,int largeCount,int maxStay){
        this.maxStay=maxStay;
        for(int i=0;i<BikeCount;i++){
            slots.add(new ParkingSlot(SlotKind.BIKE));
        }
        for()
    }
}
