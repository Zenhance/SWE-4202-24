public abstract class Vehicle {
    String numberPlate;
    int hoursPassed;
    Scheme scheme;

    public Vehicle(String numberPlate, String discount) {
        this.numberPlate = numberPlate;
        if(discount.equals(Scheme.NONE)) {
            this.scheme = Scheme.NONE;
        }else if(discount.equals(Scheme.STUDENT)){
            this.scheme = Scheme.STUDENT;
        }else if(discount.equals(Scheme.WEEKEND)){
            this.scheme = Scheme.WEEKEND;
        }
    }

}
