public class NoDiscount implements Discount{
    public int getDiscountedBill(int bill){
        return bill;
    }
}
