import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CarPark park = null;

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] field = line.split("\\s+");

            if (field[0].equals("END")) {
                break;
            }

        }
    }
}