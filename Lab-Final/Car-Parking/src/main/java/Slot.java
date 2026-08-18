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
}