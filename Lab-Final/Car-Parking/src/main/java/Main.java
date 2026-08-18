import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    static int bikeSlots,regularSlots,largeSlots;
    static int freeBike, freeRegular, freeLarge;

    static ArrayList<String> plates = new ArrayList<>();
    static ArrayList<String> types = new ArrayList<>();
    static ArrayList<String> discounts = new ArrayList<>();
    static ArrayList<String> parkedIn = new ArrayList<>();
    static ArrayList<Integer> hoursParked = new ArrayList<>();

    static int maxStay;
    static int refusedCount = 0;
    static int totalEarned = 0;

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            String line = input.nextLine().trim();
            String[] field = line.split(" ");
            String firstWord=field[0];

            if (firstWord.equals("END")) {
                break;
            }else if(firstWord.equals("SLOTS")){
                bikeSlots = parseInt(field[1]);
                regularSlots = parseInt(field[2]);
                largeSlots = parseInt(field[3]);
                freeBike = bikeSlots;
                freeRegular = regularSlots;
                freeLarge = largeSlots;
            }else if (firstWord.equals("MAXSTAY")) {
                maxStay = Integer.parseInt(field[1]);
            }else if (firstWord.equals("BIKE") || firstWord.equals("CAR") || firstWord.equals("TRUCK")) {
                plates.add(field[1]);
                types.add(firstWord);
                discounts.add(field[2]);
                parkedIn.add(firstWord);
                hoursParked.add(0);
            }else if (firstWord.equals("SLOT")) {

            } else if (firstWord.equals("FREE")) {

            }else if (firstWord.equals("COUNT")) {

            }else if(firstWord.equals("REFUSED")){
                System.out.println(refusedCount);
            }else if (firstWord.equals("BILL")) {

            }else if (firstWord.equals("PASSTIME")) {
                int hrs = Integer.parseInt(field[1]);

            }else if(firstWord.equals("LEAVE")){

            }else if (firstWord.equals("EARNED")) {
                System.out.println(totalEarned);
            }


            }

    }
    static int indexOf(String plate) {
        for (int i = 0; i < plates.size(); i++) {
            if (plates.get(i).equals(plate)) return i;
        }
        return -1;
    }
    static String parkVehicle(String plate){
        int i = indexOf(plate);
        String type = types.get(i);
        if(type.equals("BIKE")){
            if (freeBike > 0) { freeBike--; parkedIn.set(i, "BIKE"); return "BIKE"; }
            if (freeRegular > 0) { freeRegular--; parkedIn.set(i, "REGULAR"); return "REGULAR"; }
            if (freeLarge > 0) { freeLarge--; parkedIn.set(i, "LARGE"); return "LARGE"; }
        }else if (type.equals("CAR")) {
            if (freeRegular > 0) { freeRegular--; parkedIn.set(i, "REGULAR"); return "REGULAR"; }
            if (freeLarge > 0) { freeLarge--; parkedIn.set(i, "LARGE"); return "LARGE"; }

        }else if (type.equals("TRUCK")) {
            if (freeLarge > 0) { freeLarge--; parkedIn.set(i, "LARGE"); return "LARGE"; }
        }

    }
}