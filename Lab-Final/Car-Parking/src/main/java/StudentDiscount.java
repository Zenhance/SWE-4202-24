public class StudentDiscount implements Discount{
    public int discount(int bill){
        return bill-((20*bill)/100);
    }
}
