public class Regular extends Slot{
    private static int total;
    private static int count;

    public Regular(String license, String Scheme, boolean surchargeApplicable) {
        super(license, Scheme, surchargeApplicable);
        count++;
    }

    @Override
    public int calculatefee() {
        int fee = 30 + (hours-1)*20;

        if(surchargeApplicable){
            fee += 15;
        }
        fee = feeAfterScheme(fee);


        return fee;
    }

    public static void freeUpslot(){
        count--;
    }

    public static int getRegularCount(){
        return count;
    }

    public static int getAvailableRegular(){
        return total-count;
    }

    public static void setSlotforRegular(int total){
        Regular.total = total;
    }
}
