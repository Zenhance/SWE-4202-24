import java.util.ArrayList;

public abstract class Vehicle {

    protected String number;
    protected Scheme scheme;
    public static int maxHours;
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    Vehicle(String number, String schemeS) {
        if (number.isBlank()) throw new IllegalArgumentException("No number-plate");
        this.number = number;
        switch (schemeS) {
            case "NONE" -> this.scheme = Scheme.NONE;
            case "STUDENT" -> this.scheme = Scheme.STUDENT;
            case "WEEKEND" -> this.scheme = Scheme.WEEKEND;
            default -> this.scheme = Scheme.NONE;
        }
        vehicles.add(this);
    }

    Vehicle(String number){
        this(number, "NONE");
    }

    public static Vehicle search(String number){
        for(Vehicle v: vehicles){
            if(number.equals(v.number)) return v;
        }
        return null;
    }



}
