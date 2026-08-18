public class noVehiclefoundException extends Exception {
    public noVehiclefoundException(String msg){
        super(msg);
    }
    public noVehiclefoundException(){
        super("EMPTY!!");
    }

}
