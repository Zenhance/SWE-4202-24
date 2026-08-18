import static java.lang.Math.max;

public abstract class Slot {

    protected int hours;

    protected String license;
    protected boolean StudentScheme = false;
    protected boolean WeekendScheme = false;

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

    private static int MAXSTAY;
    private static int count = 0;
    protected static int refused = 0;
    protected static int earned = 0;
    protected boolean surchargeApplicable = false;




    public abstract int calculatefee();

    public void refused(){
        refused++;
    }

    public void passtime(int hours){
        this.hours = hours;
    }

    public static void setMAXSTAY(int hours){
        MAXSTAY = hours;
    }

    public void surcharge(boolean isHoldingDiffVehicle){
        surchargeApplicable = true;
    }

    protected int feeAfterSurchage(int fee){
        if (StudentScheme){
            fee = fee - (20*fee/100);
        }

        else if (WeekendScheme){
            fee = max(0, fee-10);
        }

        return fee;
    }

    public void earning(int fee){
        earned += fee;
    }

    public int getEarned(){
        return earned;
    }
}
