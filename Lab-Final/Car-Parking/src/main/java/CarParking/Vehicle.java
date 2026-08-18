package CarParking;

public interface Vehicle {
    String plate();
    DiscountPolicy discountPolicy();
    SlotKind preferredKind();
    boolean accepts(SlotKind kind);
}
