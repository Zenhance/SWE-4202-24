import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    static int bikeSlots, regularSlots, largeSlots;
    static int freeBike, freeRegular, freeLarge;

    static ArrayList<String> plates = new ArrayList<>();
    static ArrayList<String> types = new ArrayList<>();
    static ArrayList<String> discounts = new ArrayList<>();
    static ArrayList<String> parkedIn = new ArrayList<>();
    static ArrayList<Integer> hoursParked = new ArrayList<>();

    static int maxStay;
    static int refusedCount = 0;
    static int totalEarned = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            String[] field = line.split(" ");
            String firstWord = field[0];

            if (firstWord.equals("END")) {
                break;
            } else if (firstWord.equals("SLOTS")) {
                bikeSlots = parseInt(field[1]);
                regularSlots = parseInt(field[2]);
                largeSlots = parseInt(field[3]);
                freeBike = bikeSlots;
                freeRegular = regularSlots;
                freeLarge = largeSlots;
            } else if (firstWord.equals("MAXSTAY")) {
                maxStay = Integer.parseInt(field[1]);
            } else if (firstWord.equals("BIKE") || firstWord.equals("CAR") || firstWord.equals("TRUCK")) {
                plates.add(field[1]);
                types.add(firstWord);
                discounts.add(field[2]);
                parkedIn.add("");
                hoursParked.add(0);
            } else if (firstWord.equals("SLOT")) {
                System.out.println(parkVehicle(field[1]));
            } else if (firstWord.equals("FREE")) {
                System.out.println(freeSlots(field[1]));
            } else if (firstWord.equals("COUNT")) {
                System.out.println(countParked());
            } else if (firstWord.equals("REFUSED")) {
                System.out.println(refusedCount);
            } else if (firstWord.equals("BILL")) {

            } else if (firstWord.equals("PASSTIME")) {
                int hrs = Integer.parseInt(field[1]);

            } else if (firstWord.equals("LEAVE")) {

            } else if (firstWord.equals("EARNED")) {
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

    static String parkVehicle(String plate) {
        int i = indexOf(plate);
        String type = types.get(i);
        if (type.equals("BIKE")) {
            if (freeBike > 0) {
                freeBike--;
                parkedIn.set(i, "BIKE");
                return "BIKE";
            }
            if (freeRegular > 0) {
                freeRegular--;
                parkedIn.set(i, "REGULAR");
                return "REGULAR";
            }
            if (freeLarge > 0) {
                freeLarge--;
                parkedIn.set(i, "LARGE");
                return "LARGE";
            }
        } else if (type.equals("CAR")) {
            if (freeRegular > 0) {
                freeRegular--;
                parkedIn.set(i, "REGULAR");
                return "REGULAR";
            }
            if (freeLarge > 0) {
                freeLarge--;
                parkedIn.set(i, "LARGE");
                return "LARGE";
            }

        } else if (type.equals("TRUCK")) {
            if (freeLarge > 0) {
                freeLarge--;
                parkedIn.set(i, "LARGE");
                return "LARGE";
            }
        }
        refusedCount++;
        return "REFUSED";

    }

    static int freeSlots(String category) {
        if (category.equals("BIKE")) return freeBike;
        if (category.equals("REGULAR")) return freeRegular;
        return freeLarge;
    }

    static int countParked() {
        int count = 0;
        for (String p : parkedIn) {
            if (!p.equals("")) count++;
        }
        return count;
    }

    static int billFor(String plate) {
        int i = indexOf(plate);
        if (i == -1 || parkedIn.get(i).equals("")) return 0;

        String type = types.get(i);
        String parkedSlot = parkedIn.get(i);

        int h = Math.max(1, hoursParked.get(i));

        int firstHourRate = 0;
        int furtherHourRate = 0;
        int surchargeAmt = 0;

        if (parkedSlot.equals("BIKE")) {
            firstHourRate = 10;
            furtherHourRate = 5;
            surchargeAmt = 0;
        } else if (parkedSlot.equals("REGULAR")) {
            firstHourRate = 30;
            furtherHourRate = 20;
            surchargeAmt = 15;
        } else if (parkedSlot.equals("LARGE")) {
            firstHourRate = 50;
            furtherHourRate = 40;
            surchargeAmt = 25;
        }
        int bill = firstHourRate + (h - 1) * furtherHourRate;
        boolean inOwnSlot = false;
        if (type.equals("BIKE") && parkedSlot.equals("BIKE")) inOwnSlot = true;
        if (type.equals("CAR") && parkedSlot.equals("REGULAR")) inOwnSlot = true;
        if (type.equals("TRUCK") && parkedSlot.equals("LARGE")) inOwnSlot = true;
        if (!inOwnSlot) {
            bill += surchargeAmt;
        }
        String discount = discounts.get(i);
        if (discount.equals("STUDENT")) {
            int deduction = (20 * bill) / 100;
            bill -= deduction;
        } else if (discount.equals("WEEKEND")) {
            bill = (bill - 10);
        }

        return bill;
    }
    static void leaveVehicle(String plate) {
        int i = indexOf(plate);
        if (i == -1 || parkedIn.get(i).equals("")) return;
        totalEarned += billFor(plate);
        String category = parkedIn.get(i);
        if (category.equals("BIKE")){
            freeBike++;
        } else if (category.equals("REGULAR")) {
            freeRegular++;
        } else {
            freeLarge++;
        }
        }
    }

