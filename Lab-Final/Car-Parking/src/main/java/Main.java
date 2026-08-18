import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidEntrySlipException, BlankEntrySlipException, SlotUnavailableException {
    Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] field = line.split(" ");
//            for(String x: field)
//                System.out.println(x);

            if(field[0].equals("END")){
                break;
            }
            else if(field[0].equals("SLOTS")){

            }
            else if(field[0].equals("MAXSTAY")){
                int hour = Integer.parseInt(field[1]);
                Vehicle.setMaxStay(hour);
            }
            else if(field[0].equals("BIKE")){
                if(field[1].equals("NONE")){
                    throw new InvalidEntrySlipException("The plate no is not valid");
                }
                if(field[2].equals("NONE")){

                }
                if(field[2].equals("STUDENT")){

                }
                if(field[2].equals("WEEKEND")){

                }
            }
            else if(field[0].equals("CAR")){
                if(field[1].equals("NONE")){
                    throw new InvalidEntrySlipException("The plate no is not valid");
                }
                if(field[2].equals("NONE")){

                }
                if(field[2].equals("STUDENT")){

                }
                if(field[2].equals("WEEKEND")){

                }
            }
            else if(field[0].equals("TRUCK")){
                if(field[1].equals("NONE")){
                    throw new InvalidEntrySlipException("The plate no is not valid");
                }
                if(field[2].equals("NONE")){

                }
                if(field[2].equals("STUDENT")){

                }
                if(field[2].equals("WEEKEND")){

                }
            }
            else if(field[0].equals("SLOT")){

            }
            else if(field[0].equals("FREE")){

            }
            else if(field[0].equals("COUNT")){

            }
            else if(field[0].equals("REFUSED")){

            }
            else if(field[0]. equals("BILL")){

            }
            else if(field[0].equals("LEAVE")) {

            }
        }
    }
}