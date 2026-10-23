import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int bikeSlots = 0;
        int regularSlots = 0;
        int largeSlots = 0;
        CarPark park = null;
        int refused = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");
            String command = field[0];

            if (command.equals("END")) {
                break;
            }

            try {
                switch (command) {
                    case "SLOTS" -> {
                        bikeSlots = Integer.parseInt(field[1]);
                        regularSlots = Integer.parseInt(field[2]);
                        largeSlots = Integer.parseInt(field[3]);
                    }
                    case "MAXSTAY" -> park = new CarPark(bikeSlots, regularSlots, largeSlots,
                            Integer.parseInt(field[1]));
                    case "BIKE", "CAR", "TRUCK" -> park.admit(vehicleFrom(command, field[1], field[2]));
                    case "PASSTIME" -> park.passTime(Integer.parseInt(field[1]));
                    case "LEAVE" -> park.leave(field[1]);
                    case "BILL" -> System.out.println(billOrNone(park, field[1]));
                    case "SLOT" -> System.out.println(slotOrNone(park, field[1]));
                    case "FREE" -> System.out.println(park.freeSlots(field[1]));
                    case "COUNT" -> System.out.println(park.count());
                    case "EARNED" -> System.out.println(park.earnings());
                    case "REFUSED" -> System.out.println(refused);
                    default -> {
                    }
                }
            } catch (InvalidVehicleException | NoSlotFreeException | VehicleNotFoundException refusal) {
                refused = refused + 1;
            }
        }
    }

    private static Vehicle vehicleFrom(String kind, String plate, String scheme)
            throws InvalidVehicleException {
        String realPlate = plate.equals("-") ? "" : plate;
        Discount discount = discountFrom(scheme);
        return switch (kind) {
            case "BIKE" -> new Motorcycle(realPlate, discount);
            case "CAR" -> new Car(realPlate, discount);
            default -> new Truck(realPlate, discount);
        };
    }


    private static Discount discountFrom(String scheme) {
        return switch (scheme) {
            case "NONE" -> new NoDiscount();
            case "STUDENT" -> new StudentDiscount();
            case "WEEKEND" -> new WeekendDiscount();
            default -> null;
        };
    }

    private static String billOrNone(CarPark park, String plate) {
        try {
            return String.valueOf(park.billOf(plate));
        } catch (VehicleNotFoundException notHere) {
            return "NONE";
        }
    }

    private static String slotOrNone(CarPark park, String plate) {
        try {
            return park.slotOf(plate);
        } catch (VehicleNotFoundException notHere) {
            return "NONE";
        }
    }
}
