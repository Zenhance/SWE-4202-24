public enum Scheme {
    NONE {
        int apply(int bill) {
            return bill;
        }
    },
    STUDENT {
        int apply(int bill) {
            return bill - (20 * bill) / 100;
        }
    },
WEEKEND {
        int apply(int bill){
            return Math.max(0,bill-10);
        }
    }
}