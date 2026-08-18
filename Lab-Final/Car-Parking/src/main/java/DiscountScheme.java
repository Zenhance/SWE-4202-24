public enum DiscountScheme {
    NONE {
        public int apply(int bill) {
            return bill;
        }
    },
        STUDENT{
            public int apply(int bill){
                return bill-(bill-((20*bill)/100));
            }
        },
    WEEKEND{
        public int apply(int bill){
            return Math.max(0,bill-10);
        }
    };
    public abstract int apply(int bill);
    }

