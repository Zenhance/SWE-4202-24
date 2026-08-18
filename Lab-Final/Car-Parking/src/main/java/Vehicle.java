import java.util.ArrayList;

public abstract class Vehicle {

    protected String number;
    protected Scheme scheme;
    public static int maxHours;


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





}
