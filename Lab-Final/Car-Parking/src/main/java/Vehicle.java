public abstract class Vehicle {
    String numberPlate;
    int hoursPassed;
    Scheme scheme;

    public Vehicle(String numberPlate, Scheme scheme) {
        this.numberPlate = numberPlate;
        this.scheme = scheme;
    }

}
