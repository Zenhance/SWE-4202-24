import static java.lang.Math.max;

public abstract class Slot {
    private String license;
    private int hours;
    private boolean studentScheme = false;
    private boolean weekendScheme = false;
    private boolean surchargeApplied = false;

    private static int maxStay;
    private static int totalDeclined = 0;
    private static int totalEarned = 0;

    public Slot(String license, String scheme) {
        this.license = license;
        this.hours = 0;

        if ("STUDENT".equals(scheme)) {
            this.studentScheme = true;
        } else if ("WEEKEND".equals(scheme)) {
            this.weekendScheme = true;
        }

    }

    public abstract int calculateFee();

    public void timeSpent(int hours) {
        this.hours += hours;
    }

    public void setSurchargeApplied(boolean diffVehicle) {
        this.surchargeApplied = diffVehicle;
    }

    public String getLicense() {
        return license;
    }

    public int getHours() {
        return hours;
    }

    protected int applySchemeDiscount(int fee) {
        if (studentScheme) {
            fee -= ((20 * fee) / 100);
        } else if (weekendScheme) {
            fee = max(0, fee - 10);
        }
        return fee;
    }

    public static void setMaxStay(int hours) {
        maxStay = hours;
    }

    public static int getMaxStay() {
        return maxStay;
    }

    public static void incrementDeclined() {
        totalDeclined++;
    }

    public static int getTotalDeclined() {
        return totalDeclined;
    }

    public static void addEarned(int amount) {
        totalEarned += amount;
    }

    public static int getTotalEarned() {
        return totalEarned;
    }
}