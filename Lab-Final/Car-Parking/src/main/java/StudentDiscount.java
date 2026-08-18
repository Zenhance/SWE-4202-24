public interface StudentDiscount extends Discount{
    default int discount(int bill){
        return bill-((20*bill)/100);
    }
}
