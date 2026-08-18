public class regularslots  implements Surcharge{
    private static final int firsthour_fee=30;
    private static final int furtherhour_fee=20;
    private vehicles v;


    @Override
    public long surcharge() {
        return 15;
    }
    public long rfee(int h,int bill) {
        return firsthour_fee+(h-1)*furtherhour_fee+ v.discount(bill);
    }
}
