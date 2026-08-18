public class largeslots  implements Surcharge{
    private static final int firsthour_fee=50;
    private static final int furtherhour_fee=40;
    private vehicles v;


    @Override
    public long surcharge() {
        return 25;
    }
    public long lfee(int h,int bill) {
        return firsthour_fee+(h-1)*furtherhour_fee+ v.discount(bill);
    }
}
