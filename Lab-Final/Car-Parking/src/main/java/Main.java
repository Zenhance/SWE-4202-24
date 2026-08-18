import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    static int bikeSlots,regularSlots,largeSlots;
    static int freeBike, freeRegular, freeLarge;

    ArrayList<String> plates = new ArrayList<>();
    ArrayList<String> types = new ArrayList<>();
    ArrayList<String> discounts = new ArrayList<>();
    ArrayList<String> parkedIn = new ArrayList<>();
    ArrayList<Integer> hoursParked = new ArrayList<>();

    int maxStay;
    int totalEarned = 0;

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
            }
        }

    }
}