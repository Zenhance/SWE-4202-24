public class Bike extends Slot{

    private static int total;
    private static int count;
    public Bike(String license, String Scheme, boolean surchargeApplicable) {
        super(license, Scheme, surchargeApplicable);
        count++;
    }

    @Override
    public int calculatefee() {
        int fee = 10 + (hours)*5;

        if(surchargeApplicable){
            fee += 0;
        }
        fee = feeAfterScheme(fee);

        return fee;
    }

    public static int getBikeCount(){
        return count;
    }

    public static void freeUpSlot(){
        count--;
    }

    public static int getAvailableBike(){
        return total-count;
    }

    public static void setSlotforBike(int total){
        Bike.total = total;
    }
}
