public class Parking {
    private int maxStay;

    public void setMaxStay(int maxStay) {
        this.maxStay = maxStay;
    }
    public void arrive(Vehicle vehicle) throws NoPlateException{
        if(vehicle.getNumberPlate()==null || vehicle.getNumberPlate().isBlank()){
            throw new NoPlateException("Plate not found");
        }

    }
    public void leave(String Plate) throws VehicleNotFoundException{
        if(Plate==null){
            throw new VehicleNotFoundException("Vehicle not found");
        }
    }
}
