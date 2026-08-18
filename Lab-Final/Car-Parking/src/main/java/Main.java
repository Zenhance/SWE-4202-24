import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");

            if (field[0].equals("END")) {
                break;
            }
            ArrayList<Slot> slots = new ArrayList<>();
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            switch (field[0]) {
                case "SLOTS" -> {
                    int bike = Integer.parseInt(field[1]);
                    int regular = Integer.parseInt(field[2]);
                    int large = Integer.parseInt(field[3]);
                    createSlots(slots, bike, regular, large);
                }
                case "MAXSTAY" -> {
                    int hours = Integer.parseInt(field[1]);
                    Vehicle.setMaxTimeStay(hours);
                }
                case "COUNT" -> {

                    System.out.println(/* the number you worked out */);
                }
            }
        }
    }

    public static void createSlots(ArrayList<Slot> list, int bike, int regular, int large) {
        for (int i = 0; i < bike; i++) {
            list.add(new BikeSlot());
        }
        for (int i = 0; i < regular; i++) {
            list.add(new RegularSlot());
        }
        for (int i = 0; i < large; i++) {
            list.add(new LargeSlot());
        }
    }
}