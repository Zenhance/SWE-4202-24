public abstract class Vehicle {
    /*String plate;
    String type;
    String scheme;
    String SlotType;
    int hours;*/
    String plate;
    String SlotType;
    int hours;
    String scheme;
    Vehicle(String plate, String discount) {
        this.plate = plate;
        this.hours = 0;
        if(discount.equals("WEEKEND")) {
            this.scheme = "WEEKEND";
        } else if(discount.equals("STUDENT")) {
            this.scheme = "STUDENT";
        } else {
            this.scheme = "NONE";
        }

    }
    abstract String[] getAcceptedSlots();
}




