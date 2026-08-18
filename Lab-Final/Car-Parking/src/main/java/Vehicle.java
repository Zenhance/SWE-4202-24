 import java.util.List;

public abstract class Vehicle {
        private final String numberPlate;
        private final DiscountScheme discountScheme;
        private int standingHour;
        private final SlotType currentSlot;


    protected Vehicle(String numberPlate, DiscountScheme discountScheme) {
        this.numberPlate = numberPlate;
        this.discountScheme = discountScheme;
        this.currentSlot =null;
        this.standingHour=0;
    }
    public abstract List<SlotType>acceptanceOrder();

    public SlotType homeSlot(){
        return acceptanceOrder().get(0);
    }
    public String getNumberPlate(){
        return numberPlate;
    }
    public DiscountScheme getDiscountScheme(){
        return discountScheme;
    }
    public int getStandingHour(){
        return standingHour;
    }
    public SlotType getCurrentSlot(){
        return currentSlot;
    }

    public abstract List<SlotType> acceptenceOrder();
}
