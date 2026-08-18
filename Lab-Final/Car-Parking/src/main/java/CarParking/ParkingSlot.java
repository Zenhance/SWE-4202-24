package CarParking;

public final class ParkingSlot {
    private final SlotKind kind;
    private Vehicle vehicle;
    private int hours;
    public ParkingSlot(SlotKind kind){
        this.kind=kind;
    }
    public SlotKind kind(){
        return kind;
    }
    public boolean isFree(){
        return vehicle==null;
    }
    public Vehicle vehicle(){
        return vehicle;
    }
    public int hours(){
        return hours;
    }
    public void park(Vehicle vehicle){
        if(!isFree()){
            throw new IllegalStateException("Slot is occupied");
        }
        this.vehicle=vehicle;
        this.hours=0;
    }
    public Vehicle remove(){
        Vehicle old=vehicle;
        vehicle=null;
        hours=0;
        return old;
    }
    public void addHours(int amount){
        if(!isFree()){
            hours+=amount;
        }
    }
    public int billBeforeDiscount(){
        if(!isFree()){
            return 0;
        }
        int firstHour;
        int furtherHour;
        int surcharge;
        switch (kind){
            case BIKE->{
                firstHour=10;
                        furtherHour=5;
                                surcharge=0;
            }
            case LARGE->{
                firstHour=50;
                        furtherHour=40;
                        surcharge=25;
            }
            default-> throw new AssertionError();
        }
        //A stay shorter than one hour costs one hour.
        int billedHours=Math.max(1,hours);
        int bill=firstHour+(billedHours-1)*furtherHour;
        //Surcharge if vehicle is in a different kind of slot from it's own kind.
        if(vehicle.preferredKind()!=kind){
            bill+=surcharge;
        }
        return bill;
    }
    public int bill(){
        return vehicle.discountPolicy()
                .apply(billBeforeDiscount());
    }
    public int evictionBill(int maxStay){
        int firstHour;
        int furtherHour;
        int surcharge;
        switch (kind){
            case BIKE->{
                firstHour=10;
                furtherHour=5;
                surcharge=0;
            }
            case REGULAR -> {
                firstHour=30;
                furtherHour=20;
                surcharge=15;
            }
            case LARGE -> {
                firstHour=50;
                furtherHour=40;
                surcharge=25;
            }
            default-> throw new AssertionError();
        }
        //Bill for the entire maximum hours.
        int bill=firstHour+(maxStay-1)*furtherHour;
        if(vehicle.preferredKind()!=kind){
            bill+=surcharge;
        }
        //Removal charge.
        //One further hour charge for 10 hours of maximum stay,or part of 10.
        int removalHours=(maxStay+9)/10;
        bill+=(removalHours*furtherHour);
        return vehicle.discountPolicy()
                .apply(bill);
    }

}
