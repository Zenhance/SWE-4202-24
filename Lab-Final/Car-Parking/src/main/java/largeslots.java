public class largeslots  implements Surcharge{
    private static final int firsthour_fee=50;
    private static final int furtherhour_fee=40;

    public long fee(int h,int bill) {
        return firsthour_fee+(h-1)*furtherhour_fee+bill;
    }

    @Override
    public long surcharge() {
        return 0;
    }
}
