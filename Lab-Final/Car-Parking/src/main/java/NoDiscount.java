public interface NoDiscount extends Discount{
    default int discount(int bill){
        return bill;
    }
}
