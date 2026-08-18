public class NoSlotException extends Exception{
    public NoSlotException(){
        super("there's no available slot");
    }

    public NoSlotException(String message){
        super(message);
    }
}
