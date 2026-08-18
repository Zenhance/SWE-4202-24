import exceptions.ParkingException;
import model.Bike;
import model.Car;
import model.Truck;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParkingException {
        Scanner input = new Scanner(System.in);
        ParkingLot pl = null;

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");

            if(field[0].equals("SLOTS")){
                int bikeSlot = Integer.parseInt(field[1]);
                int regularSlot = Integer.parseInt(field[2]);
                int largeSlot = Integer.parseInt(field[3]);

                pl = new ParkingLot(bikeSlot, regularSlot, largeSlot);
            }
            else if (field[0].equals("END")) {
                break;
            } else if (field[0].equals("MAXSTAY")) {
                int hours = Integer.parseInt(field[1]);
                if(pl == null){
                    throw new NullPointerException();
                }
                pl.setMaxStay(hours);
            } else if (field[0].equals("COUNT")) {
                if(pl == null){
                    throw new NullPointerException();
                }
                System.out.println(pl.count());
            }
            else if(field[0].equals("BIKE")) {
                if(pl == null){
                    throw new NullPointerException();
                }
                try {
                    pl.arrive(new Bike(field[1], field[2]));
                }
                catch (ParkingException e){
                    pl.refusedCount();
                }
            }
            else if(field[0].equals("CAR")) {
                if(pl == null){
                    throw new NullPointerException();
                }
                try {
                    pl.arrive(new Car(field[1], field[2]));
                }
                catch (ParkingException e){
                    pl.refusedCount();
                }
            }
            else if(field[0].equals("TRUCK")) {
                if(pl == null){
                    throw new NullPointerException();
                }
                try {
                    pl.arrive(new Truck(field[1], field[2]));
                }
                catch (ParkingException e){
                    pl.refusedCount();
                }
            }
            else if(field[0].equals("PASSTIME")) {
                if(pl == null){
                    throw new NullPointerException();
                }
                pl.passtime(Integer.parseInt(field[1]));
            }
            else if(field[0].equals("LEAVE")) {
                if(pl == null){
                    throw new NullPointerException();
                }
                try {
                    pl.leave(field[1]);
                }
                catch (ParkingException e){
                }
            }
            else if(field[0].equals("BILL")) {
                if(pl == null){
                    throw new NullPointerException();
                }
                System.out.println(pl.bill(field[1]));
            }
            else if(field[0].equals("SLOT")) {
                if(pl == null){
                    throw new NullPointerException();
                }
                System.out.println(pl.findSlot(field[1]).getType());
            }
            else if(field[0].equals("FREE")) {
                if(pl == null){
                    throw new NullPointerException();
                }
                System.out.println(pl.free(field[1]));
            }
            else if(field[0].equals("EARNED")) {
                if(pl == null){
                    throw new NullPointerException();
                }
                System.out.println(pl.getEarned());
            }
            else if(field[0].equals("REFUSED")) {
                if(pl == null){
                    throw new NullPointerException();
                }
                System.out.println(pl.getRefused());
            }
        }
    }
}