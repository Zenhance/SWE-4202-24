public enum DiscountScheme {
    NONE{
        public int apply(int bill){
            return bill;
        }
    },

    STUDENT{
        public int apply(int bill){
            int discount=(20*bill)/100;
            return bill-discount;
        }
    },

    WEEKEND{
        public int apply(int bill){
            int discounted=bill-10;
            return Math.max(0,discounted);
        }
    };

    public abstract int apply(int bill);
}
