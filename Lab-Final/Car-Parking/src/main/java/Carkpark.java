import java.util.ArrayList;
import java.util.List;
import Exception.NoplateException;
import Exception.NoslotException;
import Exception.NoVehicleFoundException;

public class Carkpark {
    private int freeBike;
    private int freeRegular;
    private int freeLarge;
    private int maxStay;
    private int earned=0;
    private int refused=0;

    private final List<Vehicle> parkedVehicle=new ArrayList<>();

    public void setSlots(int bike,int regular,int large){
        this.freeBike=bike;
        this.freeRegular=regular;
        this.freeLarge=large;
    }

    public void setMaxStay(int hours){
        maxStay=hours;
    }
     public int freeCount(SlotType type){
        return switch(type){
            case BIKE -> freeBike;
            case REGULAR -> freeLarge;
            case LARGE -> freeLarge;
        };
     }

     private Vehicle find(String plate){
        for(Vehicle v: parkedVehicle){
            if(v.getPlate().equals(plate)){
                return v;
            }
        }
        return null;
     }

     private void changeFreeCount(SlotType type,int count){
        switch (type){
            case BIKE -> freeBike+=count;
            case REGULAR -> freeRegular+=count;
            case LARGE -> freeLarge+=count;
        }
     }

     public void arrive(Vehicle vehicle) throws NoplateException,NoslotException{
        if(vehicle.getPlate()==null || vehicle.getPlate().equals("-")){
            throw new NoplateException("Arrived vehicle do not have a plate");
        }
        for(SlotType candidate: vehicle.acceptanceOrder()){
            if(freeCount(candidate)>0){
                changeFreeCount(candidate,-1);
                vehicle.setCurrentSlot(candidate);
                parkedVehicle.add(vehicle);
                return;
            }
        }
        throw new NoslotException();
     }

     public void leave(String plate)throws NoVehicleFoundException{
        Vehicle vehicle=find(plate);
        if(vehicle==null){
            throw new NoVehicleFoundException("The plate number "+ plate + "is not in the park");
        }
        //earned+=billedFor(vehicle,Math.max(1, vehicle.getHoursStood()));
        changeFreeCount(vehicle.getCurrentSlot(),1);
        parkedVehicle.remove(vehicle);
     }
     public void passTime(int hours){
        List<Vehicle> toEvict= new ArrayList<>();
        for(Vehicle v: parkedVehicle){
            v.addHours(hours);
        }
     }
}
