import java.util.ArrayList;

public abstract class Vehicle {

    protected String number;
    protected Scheme scheme;
    public static int maxHours;
    protected int hoursPassed = 0;


    Vehicle(String number, String schemeS) {
        if (number.isBlank()) throw new IllegalArgumentException("No number-plate");
        this.number = number;
        switch (schemeS) {
            case "NONE" -> this.scheme = Scheme.NONE;
            case "STUDENT" -> this.scheme = Scheme.STUDENT;
            case "WEEKEND" -> this.scheme = Scheme.WEEKEND;
            default -> this.scheme = Scheme.NONE;
        }

    }

    Vehicle(String number){
        this(number, "NONE");
    }

    public abstract int firstHourCharge ();
    public abstract int furtherHourCharge ();
    public abstract int Surcharge ();

    public int getHoursPassed() {
        return hoursPassed;
    }
}
