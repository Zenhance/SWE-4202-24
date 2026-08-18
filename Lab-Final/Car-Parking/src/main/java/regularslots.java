public class regularslots  implements Surcharge{
    private static final int firsthour_fee=30;
    private static final int furtherhour_fee=20;
    private vehicles v;


    @Override
    public long surcharge() {
        return 15;
    }
    public long rfee(int h,int bill) {
        int meow=  firsthour_fee+(h-1)*furtherhour_fee;
        int t=meow;
        return meow+=v.discount(t)+surcharge();
    }
}
