package CarParking;

public final  class DiscountPolicies {
    private DiscountPolicies(){

    }
    public static DiscountPolicy from(String scheme){
        return switch (scheme){
            case "NONE"-> new NoDiscount();
                case "STUDENT"->new StudentDiscount();
                    case "WEEKEND"->new WeekendDiscount();
                    default-> throw new IllegalArgumentException("Unknown discount scheme");
        };

    }
}
