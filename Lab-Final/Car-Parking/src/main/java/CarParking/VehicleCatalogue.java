package CarParking;
import java.util.HashMap;
import java.util.Map;

public final class VehicleCatalogue {
    private  final Map<String,ParkingEntry>entries
            =new HashMap<>();
            public boolean contains (String plate){
        return entries.containsKey(plate);
            }
            public void add(Vehicle vehicle, ParkingSlot slot){
                entries.put(vehicle.plate(),new ParkingEntry(vehicle,slot));
            }
            public ParkingEntry get(String plate){
                return entries.get(plate);
            }
            public ParkingEntry remove(String plate){
                return entries.remove(plate);
            }
            public int size(){
                return entries.size();
            }
            public Iterable<ParkingEntry>entries(){
                return entries.values();
            }

}
