public interface DiscountScheme {
    int apply(int bill);

    static DiscountScheme from(String name) {
        return switch (name) {
            case "STUDENT" -> new StudentDiscount();

            case "WEEKEND" -> new WeekendDiscount();

            default ->new NoDiscount();
        };
    }
}