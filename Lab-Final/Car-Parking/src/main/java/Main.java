import java.util.Scanner;

public class Main {
    public static Discount makeDiscount(String x) {
        if (x.equals("STUDENT")) {
            return new StudentDiscount();
        } else if (x.equals("WEEKEND")) {
            return new WeekendDiscount();
        } else {
            return new NoDiscount();
        }
    }

    public static Vehicle makeVehicle(String type, String plate, String d) {
        Discount discount = makeDiscount(d);
        if (type.equals("BIKE")) {
            return new Bike(plate, discount);
        } else if (type.equals("CAR")) {
            return new Car(plate, discount);
        } else {
            return new Truck(plate, discount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParkingLot park = null;
        while (sc.hasNextLine()) {
            String text = sc.nextLine().trim();

            if (text.length() == 0) {
                continue;
            }
            String[] x = text.split(" ");
            String command = x[0];
            if (command.equals("END")) {
                break;
            }
            if (command.equals("SLOTS")) {
                int a = Integer.parseInt(x[1]);
                int b = Integer.parseInt(x[2]);
                int c = Integer.parseInt(x[3]);

                park = new ParkingLot(a, b, c);
            } else if (command.equals("MAXSTAY")) {
                park.setMaxStay(Integer.parseInt(x[1]));
            } else if (command.equals("BIKE") || command.equals("CAR") || command.equals("TRUCK")) {
                try {
                    Vehicle v = makeVehicle(command, x[1], x[2]);
                    park.enter(v);
                } catch (RefusalException e) {
                    park.refused++;
                }
            } else if (command.equals("PASSTIME")) {
                int h = Integer.parseInt(x[1]);
                park.passTime(h);
            } else if (command.equals("LEAVE")) {
                try {
                    park.leave(x[1]);
                } catch (NotFoundException e) {
                    park.refused++;
                }
            } else if (command.equals("BILL")) {
                try {
                    System.out.println(park.bill(x[1]));
                } catch (NotFoundException e) {
                    System.out.println("NONE");
                }
            } else if (command.equals("SLOT")) {
                try {
                    System.out.println(park.getSlot(x[1]));
                } catch (NotFoundException e) {
                    System.out.println("NONE");
                }
            } else if (command.equals("FREE")) {
                SlotType t = SlotType.valueOf(x[1]);
                System.out.println(park.freeSlots(t));
            } else if (command.equals("COUNT")) {
                System.out.println(park.vehicles.size());
            } else if (command.equals("EARNED")) {
                System.out.println(park.earned);
            } else if (command.equals("REFUSED")) {
                System.out.println(park.refused);
            }
        }
    }
}