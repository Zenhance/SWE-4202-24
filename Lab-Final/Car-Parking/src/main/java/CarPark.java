public class CarPark {
    public ParkingSlot type;
    CarPark(ParkingSlot type){
        this.type=type;
    }
    public double Surcharge(){
        return type.Surcharge();
    }
    public double Charge(){
        return type.Charge();
    }

}
