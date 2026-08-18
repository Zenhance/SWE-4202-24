public abstract class Slot {

    private static int MAXSTAY;
    private int hours;
    private static int count = 0;
    public static int refused = 0;
    public static int earned = 0;

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

    public void refused(){
        refused++;
    }

    public void passtime(int hours){
        this.hours = hours;
    }

    public static void setMAXSTAY(int hours){
        MAXSTAY = hours;
    }
}
