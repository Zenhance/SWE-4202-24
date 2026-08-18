public class WeekendDiscount implements Discount{
    @Override
    public int getDiscountedBill(int bill){
        if((bill-10)<0){
            return 0;
        }
        return bill-10;
    }
}
