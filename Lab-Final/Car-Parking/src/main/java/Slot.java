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
}