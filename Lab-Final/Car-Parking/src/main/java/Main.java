import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int bikeSlots = 0;
        int regularSlots = 0;
        int largeSlots = 0;
        int maxStay = 0;
        ParkingLot parkingLot = null;
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");
            if (field[0].equals("END")) {
                break;
            }
            if (field[0].equals("SLOTS")) {
                bikeSlots = Integer.parseInt(field[1]);
                regularSlots = Integer.parseInt(field[2]);
                largeSlots = Integer.parseInt(field[3]);
            }
            else if (field[0].equals("MAXSTAY")) {
                maxStay = Integer.parseInt(field[1]);
                parkingLot = new ParkingLot(bikeSlots, regularSlots, largeSlots, maxStay);
            }

        }
        }
    }