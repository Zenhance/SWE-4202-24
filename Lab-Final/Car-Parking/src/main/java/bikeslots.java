public class bikeslots  implements Surcharge{
    private static final int firsthour_fee=10;
    private static final int furtherhour_fee=5;

    public long fee(int h,int bill) {
        return firsthour_fee+(h-1)*furtherhour_fee+discount(bill);
    }

    @Override
    public long surcharge() {
        return 0;
    }
}
