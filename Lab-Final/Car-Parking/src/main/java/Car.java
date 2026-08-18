import java.util.List;

public class Car extends Vehicle{
    Car(String numberPlate,Discount discount){
        super(numberPlate,discount);
    }
    public List<Slot> acceptanceOrder(){
        return List.of(Slot.REGULAR,Slot.LARGE);
    }
}
