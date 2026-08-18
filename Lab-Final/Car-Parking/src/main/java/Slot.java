public abstract class Slot {

    private int   slotNumber;
    private boolean isFree = false;
    public Slot(int slotNumber) {
        if (slotNumber == 0 ) {
            throw new IllegalArgumentException("Slot number cannot be null");
        }else   {
            this.slotNumber = slotNumber;
        }
        this.isFree = true;
    }


}
