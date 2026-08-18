public class VehiclesnotfoundException extends Exception {
    public VehiclesnotfoundException(String msg){
        super(msg);
    }
    public VehiclesnotfoundException(){
        super("EMPTY!!");
    }

}
