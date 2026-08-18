public abstract class MotorCycle extends Vehicle {
    public MotorCycle(String plate, int time, SlotType slot, schemeType scheme) {
        super(plate, time, slot, scheme);
    }

    @Override
    public SlotType[] occupiedSlot() {
        return new SlotType[0];
    }

    @Override
    public int rate() {
        return 5;
    }
}
