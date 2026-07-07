public class Meter {
    private final int opening;
    private final int closing;

    public Meter(int opening, int closing) {
        if(opening<0) {
            System.out.println("Opening can't be negative");
        }
        if(closing < opening) {
            System.out.println("Closing can't be less than negative");
        }

        this.closing = closing;
        this.opening = opening;
    }









}
