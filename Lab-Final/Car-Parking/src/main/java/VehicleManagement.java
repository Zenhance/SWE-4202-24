import java.util.ArrayList;

public class VehicleManagement
{
    private ArrayList<Vehicle> vehicles;

    public VehicleManagement()
    {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle)
    {
        vehicles.remove(vehicle);
    }

    public Vehicle findVehicle(String noPlate)
    {
        for(Vehicle vehicle : vehicles)
        {
            if(vehicle.getNumberPlate().equals(noPlate))
            {
                return vehicle;
            }
        }
        return null;
    }

    public boolean hasVehicle(String noPlate)
    {
        return findVehicle(noPlate)!=null;
    }

    public int countVehicle()
    {
        return vehicles.size();
    }

}