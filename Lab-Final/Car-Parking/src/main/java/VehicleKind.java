public class VehicleKind {
    BIKE(SlotKind.BIKE, new SlotKind[]{SlotKind.BIKE,SlotKind.REGULAR,Slotkind.LARGE}),
    CAR(SlotKind.REGULAR, new SlotKind[]{SlotKind.REGULAR,Slotkind.LARGE}),
    TRUCK(SlotKind.LARGE, new SlotKind[]{Slotkind.LARGE});

    public final SlotKind naturalSlot;
    public final SlotKind[] acceptableSlots;

    VehicleKind(Slotkind naturalSlot, SlotKind[] acceptableSlots){
        this.naturalSlot=naturalSlot;
        this.acceptableSlots=acceptableSlots;
    }
}
