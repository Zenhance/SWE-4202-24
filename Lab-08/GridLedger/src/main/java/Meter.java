public class Meter {

    private int previousReading;
    private int currentReading;

    public Meter(int previousReading, int currentReading){
        if(previousReading < 0) throw new IllegalArgumentException("previousReading cannot be negative");
        if (previousReading > currentReading) throw new IllegalArgumentException(("currentReading cannot be more than previousReadin");

        this.previousReading = previousReading;
        this.currentReading = currentReading;
    }



}
