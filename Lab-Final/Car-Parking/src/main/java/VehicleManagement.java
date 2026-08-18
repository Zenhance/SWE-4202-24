import java.util.ArrayList;
import java.util.List;


public class VehicleManagement {
    private List<Vehicle> vehicles;


    public VehicleManagement(){
        vehicles=new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }

    public Vehicle getVehicle(String plate){
        for(Vehicle v:vehicles){
            if(v.getPlate().equals(plate)){
                return v;
            }
        }
        return null;
    }

    public int countVehicles(){
        return vehicles.size();
    }

    public List<Vehicle> getVehicles(){
        return vehicles;
    }
}
