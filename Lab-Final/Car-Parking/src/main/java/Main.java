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
                
            } else if (field[0].equals("BIKE")) {
                System.out.println(/* the number you worked out */);
            }else if (field[0].equals("CAR")) {

            }else if (field[0].equals("TRUCK")) {

            }else if (field[0].equals("PASSTIME")) {

            }else if (field[0].equals("LEAVE")) {

            }else if (field[0].equals("BILL")) {

            }else if (field[0].equals("SLOT")) {

            }else if (field[0].equals("FREE")) {

            }else if (field[0].equals("COUNT")) {

            }else if (field[0].equals("EARNED")) {

            }else if (field[0].equals("REFUSED")) {

            }else if (field[0].equals("END")) {

            }

        }
    }
}