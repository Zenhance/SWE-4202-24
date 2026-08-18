import java.util.List;

public class Bike extends Vehicle{
    public Bike(String numberPlate,Discount discount){
        super(numberPlate,discount);
    }
    public List<Slot> acceptanceOrder(){
        return List.of(
               Slot.BIKE,Slot.REGULAR,Slot.LARGE
        );
    }
}
