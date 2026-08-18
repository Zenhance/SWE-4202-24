import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle{
    Car(String numberPlate,Discount discount){
        super(numberPlate,discount);
    }
    public List<Slot> acceptanceOrder(){
        List<Slot> slots=new ArrayList<>();
        slots.add(Slot.REGULAR);
        slots.add(Slot.LARGE);
        return slots;
    }
}
