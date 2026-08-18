public class WeekendDiscount implements Discount{
    @Override
    public int discount(int bill) {
        return bill-10;
    }
}
