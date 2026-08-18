public class NoslotException extends Exception{
    public NoslotException(){
        super("There is no available slot");
    }
    public NoslotException(String message){
        super(message);
    }
}
