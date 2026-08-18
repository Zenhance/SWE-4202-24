public class largeslots  implements Surcharge{
    private static final int firsthour_fee=50;
    private static final int furtherhour_fee=40;
    private vehicles v;


    @Override
    public long surcharge() {
        return 25;
    }
    public long lfee(int h,int bill) {
        int meow=  firsthour_fee+(h-1)*furtherhour_fee;
        int t=meow;
        return meow+=v.discount(t)+surcharge();
    }
}
