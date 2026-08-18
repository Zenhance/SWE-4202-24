public class PlateNotPark extends RuntimeException {
    public PlateNotPark(String message) {
        super("Plate is not in the park ");
    }
}
