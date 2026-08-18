public class NoDiscount implements DiscountScheme {
        @Override
        public int applyDiscount(int bill) {
            return bill;
        }
    }

