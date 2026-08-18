import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

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
                System.out.println(/* the number you worked out */);
            } else if (field[0].equals("SLOTS")) {
                int bike = Integer.parseInt(field[1]);
                int regular = Integer.parseInt(field[2]);
                int large = Integer.parseInt(field[3]);
                ParkingLot p = new ParkingLot(bike, regular, large);
            }
            else if (field[0].equals("SLOT")) {
                Vehicle v = ParkingLot.search(field[1]);
                    if (v != null) {
                        //Slot s = new Slot(v);
                    }
            }
            // ... one branch per keyword ...

        }
    }
}