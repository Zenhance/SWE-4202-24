import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int maxBike = 0;
    private static int maxRegular = 0;
    private static int maxLarge = 0;

    private static List<Slot> activeSlots = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String opt = scanner.next();

            switch (opt) {
                case "SLOTS" -> {

                    maxBike = scanner.nextInt();

                    maxRegular = scanner.nextInt();

                    maxLarge = scanner.nextInt();

                }
                case "MAXSTAY" -> {
                    int hours = scanner.nextInt();
                    Slot.setMaxStay(hours);
                }
                case "BIKE" ->
            }
        }

    }
}