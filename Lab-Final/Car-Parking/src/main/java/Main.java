import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CarPark carPark = null;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] field = line.split(" ");
            String command = field[0];

            if (command.equals("END")) {
                break;
            }

            if (command.equals("SLOTS")) {
                int bikeSlots = Integer.parseInt(field[1]);
                int regularSlots = Integer.parseInt(field[2]);
                int largeSlots = Integer.parseInt(field[3]);

                carPark = new CarPark(bikeSlots, regularSlots, largeSlots);
            }

        }
    }
}