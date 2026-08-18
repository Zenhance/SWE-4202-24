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
            } else if (field[0].equals("SLOTS")) {
                ParkingLot parkingLot = new ParkingLot(Integer.parseInt(field[1]), Integer.parseInt(field[2]), Integer.parseInt(field[3]));
            } else if (field[0].equals("MAXSTAY")) {
                int hours = Integer.parseInt(field[1]);
                
            } else if (field[0].equals("COUNT")) {
                System.out.println(/* the number you worked out */);
            }
            // ... one branch per keyword ...
        }
    }
}