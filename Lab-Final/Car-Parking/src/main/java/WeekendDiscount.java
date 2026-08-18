public interface WeekendDiscount extends Discount{
    @Override
    default int discount(int bill) {
        return bill-10;
    }
}
