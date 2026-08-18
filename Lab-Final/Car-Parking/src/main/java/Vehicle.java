public abstract class Vehicle {

    String number;
    Scheme scheme;

    Vehicle(String number, String schemeS) {
        if (number.isBlank()) throw new IllegalArgumentException("No number-plate");
        this.number = number;
        switch (schemeS) {
            case "NONE" -> this.scheme = Scheme.NONE;
            case "STUDENT" -> this.scheme = Scheme.STUDENT;
            case "WEEKEND" -> this.scheme = Scheme.WEEKEND;

        }
    }

    Vehicle(String number){
        this(number, Scheme.NONE);
    }


}
