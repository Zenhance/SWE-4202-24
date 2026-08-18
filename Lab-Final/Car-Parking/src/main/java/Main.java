import java.util.Scanner;
import java.util.*;


public class Main {
    private static int maxBikeSlots = 0;
    private static int maxRegularSlots = 0;
    private static int maxLargeSlots = 0;
    private static final List<Slot> activeSlots = new ArrayList<>();


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String command = scanner.next();

            switch (command) {
                case "SLOTS" ->{
                    maxBikeSlots = scanner.nextInt();
                    maxRegularSlots = scanner.nextInt();
                    maxLargeSlots = scanner.nextInt();
                }
                case "MAXSTAY" -> {
                    int hours = scanner.nextInt();
                    Slot.setMaxStay(hours);
                }
                case "BIKE" -> admitVehicle("BIKE", scanner.next(), scanner.next());
                case "CAR" -> admitVehicle("CAR", scanner.next(), scanner.next());
                case "TRUCK" -> admitVehicle("TRUCK", scanner.next(), scanner.next());

                case "COUNT" -> System.out.println(activeSlots.size());

                case "END" -> {
                    return;
                }
            }
        }
    }

    private static void admitVehicle(String vehicleType, String plate, String scheme) {}

}








