import java.util.ArrayList;
import java.util.List;
public class Truck extends Vehicle{
    Truck(String numberPlate,Discount discount){
        super(numberPlate, discount);
    }
    public List<Slot> acceptanceOrder(){
        List<Slot> slots=new ArrayList<>();
        slots.add(Slot.LARGE);
        return slots;
    }

}
