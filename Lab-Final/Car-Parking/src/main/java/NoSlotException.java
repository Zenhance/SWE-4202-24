public class NoSlotException extends Exception{
    public NoSlotException(){
        super("No plate found");
    }
    public NoSlotException(String message){
        super(message);
    }
}
