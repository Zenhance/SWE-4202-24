public abstract class Vehicle {
    private String carKind;
    private String numPLate;

    Vehicle(String carKind, String numPLate){

        this.numPLate=numPLate;
    }
    public abstract void fee();
}
