public class StudentDiscount implements Discount{
    @Override
    public int getDiscountedBill(int bill){
        return (int) (bill-((bill*20)/100));
    }

}
