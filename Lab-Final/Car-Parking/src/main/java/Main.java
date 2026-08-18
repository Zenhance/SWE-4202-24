import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParkingLot park = null;

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");

            if (field[0].equals("END")) {
                break;
            }

            else if (field[0].equals("SLOTS")) {
                int bike = Integer.parseInt(field[1]);
                int regular = Integer.parseInt(field[2]);
                int large = Integer.parseInt(field[3]);
                park = new ParkingLot(bike, regular, large);
            }

            else if (field[0].equals("MAXSTAY")) {
                int hours = Integer.parseInt(field[1]);
                park.setMaxStay(hours);
            }

            else if (field[0].equals("PASSTIME")) {
                int hours = Integer.parseInt(field[1]);
                park.passTime(hours);
            }

            else if (field[0].equals("FREE")) {
                SlotKind kind = parseSlotKind(field[1]);
                System.out.println(park.getFreeCount(kind));
            }

            else if (field[0].equals("COUNT")) {
                System.out.println(park.getVehicleCount());
            }

            else if (field[0].equals("EARNED")) {
                System.out.println(park.getEarned());
            }

            else if (field[0].equals("REFUSED")) {
                System.out.println(park.getRefused());
            }

            else if (field[0].equals("BILL")) {
                String plate = field[1];

                try {
                    int bill = park.getBill(plate);
                    System.out.println(bill);
                }

                catch (UnknownPlateException e) {
                    System.out.println("NONE");
                }
            }

            else if (field[0].equals("SLOT")) {
                String plate = field[1];

                try {
                    SlotKind kind = park.getSlotKind(plate);
                    System.out.println(kind);
                }

                catch (UnknownPlateException e) {
                    System.out.println("NONE");
                }
            }

            else if (field[0].equals("LEAVE")) {
                String plate = field[1];

                try {
                    park.leave(plate);
                }

                catch (UnknownPlateException e) {
                    park.incrementRefused();
                }
            }

            else if (field[0].equals("BIKE") || field[0].equals("CAR") || field[0].equals("TRUCK")) {
                String plate = field[1];
                String scheme = field[2];

                try {
                    if (plate.equals("-")) {
                        throw new BlankPlateException();
                    }
                    DiscountScheme discount = parseDiscountScheme(scheme);
                    Vehicle vehicle = createVehicle(field[0], plate, discount);
                    park.admit(vehicle);
                }

                catch (BlankPlateException | NoSlotAvailableException e) {
                    park.incrementRefused();
                }
            }
        }
    }

    private static DiscountScheme parseDiscountScheme(String scheme) {
        return switch (scheme) {
            case "NONE" -> new NoDiscount();
            case "STUDENT" -> new StudentDiscount();
            case "WEEKEND" -> new WeekendDiscount();
            default -> new NoDiscount();
        };
    }

    private static Vehicle createVehicle(String type, String plate, DiscountScheme discount) {
        return switch (type) {
            case "BIKE" -> new Motorcycle(plate, discount);
            case "CAR" -> new Car(plate, discount);
            case "TRUCK" -> new Truck(plate, discount);
            default -> null;
        };
    }

    private static SlotKind parseSlotKind(String kind) {
        return switch (kind) {
            case "BIKE" -> SlotKind.BIKE;
            case "REGULAR" -> SlotKind.REGULAR;
            case "LARGE" -> SlotKind.LARGE;
            default -> null;
        };
    }
}

