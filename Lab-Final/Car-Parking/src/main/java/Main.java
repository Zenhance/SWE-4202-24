import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CarParking park = null;

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] field = line.split("\\s+");

            if (field[0].equals("END")) {
                break;
            }

            switch (field[0]) {
                case "SLOTS" -> park = new CarParking(
                        Integer.parseInt(field[1]),
                        Integer.parseInt(field[2]),
                        Integer.parseInt(field[3]));

                case "MAXSTAY" ->
                        park.setMaximumStay(Integer.parseInt(field[1]));

                case "BIKE", "CAR", "TRUCK" ->
                        admit(park, field[0], field[1], field[2]);

                case "PASSTIME" ->
                        park.passTime(Integer.parseInt(field[1]));

                case "LEAVE" ->
                        leave(park, field[1]);

                case "BILL" ->
                        printBill(park, field[1]);

                case "SLOT" ->
                        printSlot(park, field[1]);

                case "FREE" ->
                        System.out.println(
                                park.freeSlots(SlotKind.valueOf(field[1]))
                        );

                case "COUNT" ->
                        System.out.println(park.vehicleCount());

                case "EARNED" ->
                        System.out.println(park.earned());

                case "REFUSED" ->
                        System.out.println(park.refused());
            }
        }
    }

    private static void admit(CarParking park, String type, String plate, String schemeName
    ) {
        DiscountScheme scheme =
                DiscountScheme.from(schemeName);

        Vehicle vehicle = switch (type) {
            case "BIKE" ->
                    new Motorcycle(plate, scheme);

            case "CAR" ->
                    new Car(plate, scheme);

            default ->
                    new Truck(plate, scheme);
        };

        try {
            park.admit(vehicle);
        } catch (ParkingException exception) {
            park.recordRefusal();
        }
    }

    private static void leave(
            CarParking park,
            String plate
    ) {
        try {
            park.leave(plate);
        } catch (VehiclesNotFoundException exception) {
            park.recordRefusal();
        }
    }
}
