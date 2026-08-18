public class Large extends Slot{

    private static int total;
    private static int count;

    public Large(String license, String Scheme, boolean surchargeApplicable) {
        super(license, Scheme, surchargeApplicable);
        count++;
    }

    @Override
    public int calculatefee() {
        int fee = 50 + (hours)*40;

        if(surchargeApplicable){
            fee += 25;
        }
        fee = feeAfterScheme(fee);

        return fee;
    }

    public static void freeUpslot(){
        count--;
    }

    public static int getLargeCount(){
        return count;
    }

    public static int getAvailableLarge(){
        return total-count;
    }

    public static void setSlotforLarge(int total){
        Large.total = total;
    }
}
