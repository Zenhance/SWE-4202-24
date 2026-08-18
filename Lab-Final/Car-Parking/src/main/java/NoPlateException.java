public abstract class NoPlateException extends Exception{
    protected NoPlateException(String plate) {
        super(plate);
    }
}