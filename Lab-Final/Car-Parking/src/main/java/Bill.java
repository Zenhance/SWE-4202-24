public class Bill
{
    public int calculate(Vehicle vehicle, int hours)
    {
        if(hours<1) hours=1;
        Slot slot = vehicle.getSlot();
        int bill= slot.firstHourRate()+(hours-1)*slot.furtherHourRate()+ slot.surcharge();
        bill=applyDiscount(bill,vehicle.getScheme());
        return Math.max(0,bill);
    }

    private int applyDiscount(int bill, Vehicle.DiscountScheme scheme)
    {
        if(scheme==Vehicle.DiscountScheme.NONE) return bill;
        else if(scheme==Vehicle.DiscountScheme.STUDENT)
        {
            bill=bill-(bill*20)/100;
            return bill;
        }
        return Math.max(0,bill-10);
    }
}