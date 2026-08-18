import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ParkingLot lot = null;
        While(input.hasNextLine()){
            String Line = input.nextLine().trim();
            if(line.isEmpty()){
                continue;
            }
            String[] field = line.split(" ");
            String word = field[0];

            if(word.equals("END")){
                break;
            } else if (word.equals("SLOTS")) {
                int bike = Integer.parseInt(field[1]);
                int regular = Integer.parseInt(field[2]);
                int large = Integer.parseInt(field[3]);
                lot = new ParkingLot(bike,regular,large);
            }else if(word.equals("MAXSTAY")){
                lot.setMaxStay(Integer.parseInt(field[1]));
            }else if(word.equals("BIKE")){
                lot.arrive(field[1],  ); ///////////////
            }else if(word.equals("CAR")){
                lot.arrive(field[1],  ); ////////////
            }else if(word.equals("TRUCK")){
                lot.arrive(field[1,  ]); //////////////
            }else if(word.equals("PASSTIME")){
                lot.passTime(Integer.parseInt(field[1]));
            }else if(word.equals("LEAVE")){
                lot.leave(field[1]);
            }else if(word.equals("BILL")){
                System.out.println(lot.bill(field[1]));
            }else if(word.equals("SLOT")){
                System.out.println(lot.slotOf(field[1]));
            }else if(word.equals("FREE")){
                System.out.println("lot.   ");  ///////////////
            }else if(word.equals("COUNT")){
                System.out.println(lot.count());
            }else if(word.equals("EARNED")){
                System.out.println(lot.earned());
            }else if(word.equals("REFUSED")){
                System.out.println(lot.refused());
            }
        }
    }
}