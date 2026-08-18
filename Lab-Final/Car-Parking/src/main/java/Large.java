public class Large extends Slot{
    public Large(String license, String Scheme) {
        super(license, Scheme);
    }

    @Override
    public int fee() {
        return 0;
    }
}
