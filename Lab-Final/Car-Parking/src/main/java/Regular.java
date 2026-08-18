public class Regular extends Slot{
    public Regular(String license, String Scheme) {
        super(license, Scheme);
    }

    @Override
    public int fee() {
        return 0;
    }
}
