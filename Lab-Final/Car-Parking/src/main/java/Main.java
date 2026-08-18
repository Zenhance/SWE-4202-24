import java.util.Scanner;

class BlankPlateException extends Exception
{

}
class NoSlotAvailableException extends Exception
{

}
class VehicleNotFoundException extends Exception
{

}

enum SlotType
{
    BIKE, REGULAR, LARGE
}

interface DiscountScheme
{
    int applyDiscount(int billAmount);
}


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
            } else if (field[0].equals("COUNT")) {
                System.out.println(/* the number you worked out */);
            }
            // ... one branch per keyword ...
        }
    }
}