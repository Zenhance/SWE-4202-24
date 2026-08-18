public interface DiscountScheme {
    int apply (int bill);
    static DiscountScheme from (String name){
        return switch (name) {
            case "Student" ->
                new StudentDiscount();
            case "WEEKEND" ->
                new WeekendDiscount();
            default ->
                new NoDiscount();
        };
    }
}
