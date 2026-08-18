package Exception;

public class NoplateException extends Exception{
    public NoplateException(){
        super("There is no plate");
    }
    public NoplateException(String message){
        super(message);
    }
}
