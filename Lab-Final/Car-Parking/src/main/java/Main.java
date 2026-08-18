import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();
        while (input.hasNextLine()){
            String line = input.nextLine().trim();
            if (line.isEmpty()){
                continue;
            }
            String[] field = line.split("\\s+");
            String command = field[0];
            if (command.equals("END")){
                break;
            }
            if (command.equals("SLOTS")) {
                int bikeSlots = Integer.parseInt(field[1]);
                int regularSlots = Integer.parseInt(field[2]);
                int largeSlots = Integer.parseInt(field[3]);
                parkingLot.setSlots(bikeSlots, regularSlots, largeSlots);
            }
        }

    }
}