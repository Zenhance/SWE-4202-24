public class bikeslots  implements Surcharge{
    private static final int firsthour_fee=10;
    private static final int furtherhour_fee=5;
    private vehicles v;


    @Override
    public long surcharge() {
        return 0;
    }
    public long bfee(int h,int bill) {
        return firsthour_fee+(h-1)*furtherhour_fee+ v.discount(bill)+surcharge();
    }
}
