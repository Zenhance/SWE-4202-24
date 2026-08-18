public class Large extends Slot{

    private static int total;
    private static int count;

    public Large(String license, String Scheme) {
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

    public int getLargeCount(){
        return count;
    }

    public int getAvailableLarge(){
        return total-count;
    }

    public static void setSlotforLarge(int total){
        Large.total = total;
    }
}
