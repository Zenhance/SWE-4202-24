import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParkingLot p = null;
        //ArrayList<Vehicle> queued = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");

            if (field[0].equals("END")) {
                break;
            } else if (field[0].equals("MAXSTAY")) {
                int hours = Integer.parseInt(field[1]);
                // ... do something with hours ...
                Vehicle.maxHours = hours;
            } else if (field[0].equals("COUNT")) {
                if(p!=null)
                    System.out.println(p.getCount()/* the number you worked out */);
            } else if (field[0].equals("SLOTS") && field.length >= 4) {
                int bike = Integer.parseInt(field[1]);
                int regular = Integer.parseInt(field[2]);
                int large = Integer.parseInt(field[3]);
                p = new ParkingLot(bike, regular, large);
            }
            else if (field[0].equals("SLOT") && field.length >= 2) {
                if(p != null)
                    System.out.println(p.slotVehicle(field[1]));
            }
            else if (field[0].equals("BIKE")) {
                Vehicle v = new Bike(field[1], field[2]);
                if (p != null)
                    p.enterVehicle(v);
            }
            else if (field[0].equals("CAR")) {
                Vehicle v = new Car(field[1], field[2]);
                if (p != null)
                    p.enterVehicle(v);
            }
            else if (field[0].equals("TRUCK")) {
                Vehicle v = new Truck(field[1], field[2]);
                if (p != null)
                    p.enterVehicle(v);
            } else if (field[0].equals("FREE")) {
                if(p != null) {
                    if (field[1].equals("BIKE"))
                        System.out.println(p.getFreeBikeSlot());
                    if (field[1].equals("REGULAR"))
                        System.out.println(p.getFreeRegularSlot());
                    if (field[1].equals("LARGE"))
                        System.out.println(p.getFreeLargeSlot());
                }
            }
            else if (field[0].equals("REFUSED")) {
                if (p != null)
                    System.out.println(p.getRefused()/* the number you worked out */);
            }
            // ... one branch per keyword ...

        }
    }
}