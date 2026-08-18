public class Bike extends Slot{

    private static int total;
    private static int count;
    public Bike(String license, String Scheme) {
        super(license, Scheme);
        count++;
    }

    @Override
    public int calculatefee() {
        int fee = 10 + hours*5;

        if(surchargeApplicable){
            fee += 0;
        }
        fee = feeAfterSurchage(fee);

        earning(fee);

        return fee;
    }

    public int getBikeCount(){
        return count;
    }

    public int getAvailableBike(){
        return total-count;
    }

    public static void setSlotforBike(int total){
        Bike.total = total;
    }
}
