public abstract class Slot {
    private final int count;
    private boolean isFree;

    public Slot(int count) {
        this.count = count;
        this.isFree = true;
    }
}
