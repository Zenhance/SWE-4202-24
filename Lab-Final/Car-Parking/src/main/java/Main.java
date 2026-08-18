import Records.HoursPassed;

import java.util.Scanner;
import Records.*;

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
            } else if (field[0].equals("MAXSTAY")) {

            } else if (field[0].equals("COUNT")) {

            }
            else if (field[0].equals("SLOT")) {
                Bike.set(field[1]);
                Regular.set(field[2]);
                Large.set(field[3]);

            }
            else if (field[0].equals("BILL")) {

            }else if (field[0].equals("BIKE")) {

            }else if (field[0].equals("CAR")) {

            }else if (field[0].equals("TRUCK")) {

            }else if (field[0].equals("PASSTIME")) {
                int hours = Integer.parseInt(field[1]);
                HoursPassed.set(hours);

            }else if (field[0].equals("LEAVE")) {

            }else if (field[0].equals("FREE")) {

            }
            else if (field[0].equals("COUNT")) {

            }else if (field[0].equals("EARNED")) {

            }else if (field[0].equals("REFUSED")) {

            }

            // ... one branch per keyword ...
        }
    }
}