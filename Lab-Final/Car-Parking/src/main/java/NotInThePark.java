public abstract class NotInThePark extends Exception {
    protected NoSlotException(String plate) {
        super(plate);
    }
}
