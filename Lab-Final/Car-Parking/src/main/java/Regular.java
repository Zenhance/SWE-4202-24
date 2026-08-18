public class Regular extends Slot{
    private static int total;
    private static int count;

    public Regular(String license, String Scheme) {
        super(license, Scheme);
        count++;
    }

    @Override
    public int calculatefee() {
        int fee = 30 + hours*20;

        if(surchargeApplicable){
            fee += 15;
        }
        fee = feeAfterScheme(fee);

        earning(fee);

        return fee;
    }

    public int getRegularCount(){
        return count;
    }

    public int getAvailableRegular(){
        return total-count;
    }

    public static void setSlotforRegular(int total){
        Regular.total = total;
    }
}
