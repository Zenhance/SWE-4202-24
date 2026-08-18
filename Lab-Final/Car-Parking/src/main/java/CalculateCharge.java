public class CalculateCharge {

    private final int bikeBase = 10;
    private final int regularBase = 30;
    private final int largeBase = 50;
    private final int bikeHourBase = 5;
    private final int regularHourBase = 20;
    private final int largeHourBase = 40;
    private final int bikeSurcharge = 0;
    private final int regularSurcharge = 15;
    private final int largeSurcharge = 25;


    public int bill (Vehicle v, String slot) {
        int base = 0;
        if (slot.equals("LARGE")) {
            base += largeBase;
            base += v.hoursPassed * largeHourBase;
            if (!(v instanceof Truck)) base += largeSurcharge;
        }
        if (slot.equals("REGULAR")) {
            base += regularBase;
            base += v.hoursPassed * regularHourBase;
            if (!(v instanceof Car)) base += regularSurcharge;
        }
        if (slot.equals("BIKE")) {
            base += bikeBase;
            base += v.hoursPassed * bikeHourBase;
        }
        return base;
    }
}
