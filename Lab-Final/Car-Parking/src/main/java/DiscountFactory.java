public class DiscountFactory {
    private DiscountFactory() {
    }
    public static DiscountScheme create(SchemeType type) {
        return switch (type) {
            case NONE->new NoDiscount();
            case STUDENT->new StudentDiscount();
            case WEEKEND->new WeekendDiscount();
        };
    }
}
