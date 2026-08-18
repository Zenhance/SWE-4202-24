import static java.lang.Math.max;

public abstract class Slot {

    int totalpasstime = 0;
    protected int hours = 0;
    protected static int countTotal = 0;
    protected boolean surchargeApplicable;
    protected String license;
    protected boolean StudentScheme = false;
    protected boolean WeekendScheme = false;

    public Slot(String license, String Scheme, boolean surchargeApplicable){
        this.license = license;
        this.surchargeApplicable = surchargeApplicable;

        switch(Scheme) {
            case "STUDENT" -> {
                StudentScheme = true;
            }
            case "WEEKEND" -> {
                WeekendScheme = true;
            }
        }

        countTotal++;
    }

    private static int MAXSTAY;
    protected static int refused = 0;
    public static int earned = 0;



    public abstract int calculatefee();

    public static void refused(){
        refused++;
    }

    public boolean passtime(int hours){
        this.hours = hours;
        totalpasstime += hours;

        if(totalpasstime > MAXSTAY){
            return false;
        }
        return true;
    }

    public static void setMAXSTAY(int hours){
        MAXSTAY = hours;
    }

    public void surcharge(boolean isHoldingDiffVehicle){
        surchargeApplicable = true;
    }

    protected int feeAfterScheme(int fee){
        if (StudentScheme){
            fee = fee - (20*fee/100);
        }

        else if (WeekendScheme){
            fee = max(0, fee-10);
        }

        return fee;
    }


    public static void earning(int value){
        earned += value;
    }

    public static int getEarned() {
        return earned;
    }

    public static int getCount(){
        return countTotal;
    }

    public String getLicense(){
        return license;
    }
}
