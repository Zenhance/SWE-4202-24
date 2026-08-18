import java.util.List;
public class Truck extends Vehicle{
    Truck(String numberPlate,Discount discount){
        super(numberPlate, discount);
    }
    public List<Slot> acceptanceOrder(){
        return List.of(
                Slot.LARGE
        );
    }

}
