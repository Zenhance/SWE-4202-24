import java.util.Scanner;

import Billing.BillingEngine;
import Slots.*;
import Vehicles.BIKE;

import static Records.slotCount.getCount;

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
                System.out.println(getCount());
            }
            else if (field[0].equals("SLOT")) {
                Bike.set(Integer.parseInt(field[1]));
                Regular.set(Integer.parseInt(field[2]));
                Large.set(Integer.parseInt(field[3]));

            }
            else if (field[0].equals("BILL")) {

            }else if (field[0].equals("BIKE")) {
                String s=field[1];
                BIKE b=new BIKE();
            }else if (field[0].equals("CAR")) {

            }else if (field[0].equals("TRUCK")) {

            }else if (field[0].equals("PASSTIME")) {
                int hours = Integer.parseInt(field[1]);
                BillingEngine.set(hours);

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