public enum Scheme {
    NONE {
       @Override
        public int apply(int bill) {
            return bill;
        }
    },

    STUDENT {
        @Override
        public int apply(int bill) {
            return bill - (20 * bill) / 100;
        }
    },
    WEEKEND {
        @Override
        public int apply(int bill) {
            return Math.max(0, bill - 10);
        }
    };

    public abstract int apply(int bill);
}