public class regularslots  implements Surcharge{
    private static final int firsthour_fee=30;
    private static final int furtherhour_fee=20;

    public long fee(int h,int bill) {
        return firsthour_fee+(h-1)*furtherhour_fee+bill;
    }

    @Override
    public long surcharge() {
        return 15;
    }
}
