public abstract class Slot {
    private int hours;
    private static int count = 0;
    String license;
    boolean StudentScheme = false;
    boolean WeekendScheme = false;

    public Slot(String license, String Scheme){
        hours = 1;
        this.license = license;

        switch(Scheme) {
            case "STUDENT" -> {
                StudentScheme = true;
            }
            case "WEEKEND" -> {
                WeekendScheme = true;
            }
        }

        count++;
    }

    public abstract int fee();
}
