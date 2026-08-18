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
                case "BIKE" -> {
                    admitVehicle("BIKE" , " " , " ");
                }
                case "CAR" -> {
                    admitVehicle("CAR" , " " , " ");
                }
                case "TRUCK" -> {
                    admitVehicle();
                }
                case "PASSTIME" -> {
                    admitVehicle();
                }
                case "LEAVE" -> {
                    admitVehicle();
                }
                case "BILL" -> {
                    admitVehicle();
                }
                case "SLOT" -> {
                    admitVehicle();
                }
                case "FREE" -> {
                    admitVehicle();
                }
                case "COUNT" -> System.out.println(activeSlots.size());
                case "EARNED" -> System.out.println(Slot.getTotalEarned());
                case "REFUSED" -> System.out.println(Slot.getTotalDeclined());
                case "END" -> {
                    return;
                }
            }
        }

    }

    private static void admitVehicle(String vehicleType, String plate, String scheme) {

        if ("-".equals(plate)) {
            Slot.incrementDeclined();
            return;
        }

        int occupiedBike = 0;
        int occupiedRegular = 0;
        int occupiedLarge = 0;

        for (Slot s : activeSlots) {
            if (s instanceof Bike) occupiedBike++;
            else if (s instanceof Regular) occupiedRegular++;
            else if (s instanceof Large) occupiedLarge++;
        }

        Slot allocatedSlot = null;

    }
}