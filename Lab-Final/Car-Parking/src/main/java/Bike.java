public class Bike extends Slot{

    private static int total;
    private static int count;
    public Bike(String license, String Scheme) {
        super(license, Scheme);
        count++;
    }

    @Override
    public int fee() {
        return 0;
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
