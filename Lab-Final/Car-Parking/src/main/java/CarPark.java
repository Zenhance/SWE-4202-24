import java.util.ArrayList;
public class CarPark {
    private ArrayList<ParkingSlot>slots;
    private ArrayList<Vehicle> vehicle;

    private int maxStay;
    private int earned;
    private int refused;


    public CarPark(int bikeSlots,int regularSlots,int largeSlots){
        slots=new ArrayList<>();
        vehicle=new ArrayList<>();
        earned=0;
        refused=0;

        for(int i=0;i<bikeSlots;i++){
            slots.add(new ParkingSlot("BIKE"));
        }

        for (int i=0;i<regularSlots;i++){
            slots.add(new ParkingSlot("REGUlAR"));
        }

        for (int i=0;i<largeSlots;i++){
            slots.add(new ParkingSlot("Large"));
        }
    }

    public void setMaxStay(int maxStay){
        this.maxStay=maxStay;
    }

    public void parkVehicle(Vehicle vehicle)
        throws ParkingException{
        if(vehicle.getPlate().isEmpty()){
            throw new ParkingException("No plate");
        }

        Parki
    }
}
