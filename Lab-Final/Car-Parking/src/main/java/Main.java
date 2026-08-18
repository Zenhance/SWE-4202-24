import java.util.Scanner;

import Billing.BillingEngine;
import Records.slotCount;
import Refusals.NoSpaceAvailableException;
import Slots.*;
import Vehicles.BIKE;
import Vehicles.CAR;
import Vehicles.TRUCK;

import static Billing.BillingEngine.maxStay;
import static Records.slotCount.*;

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
            maxStay(Integer.parseInt(field[1]));
            } else if (field[0].equals("COUNT")) {
                System.out.println(getCount());
            }
            else if (field[0].equals("SLOTS")) {
                slotCount.setBike(Integer.parseInt(field[1]));
                slotCount.setRegular(Integer.parseInt(field[2]));
                slotCount.setLarge(Integer.parseInt(field[3]));

            }
            else if (field[0].equals("BILL")) {

            }else if (field[0].equals("BIKE")) {
                String s1=field[1];
                String s2=field[2];
                if( getBikeCount()>0){
                    Bike slot = new Bike(s1);
                    Count();
                    addBike();
                    BIKE b=new BIKE(s1,s2, slot);
                }
                else if(getRegularCount()>0){
                    Regular slot=new Regular(s1);
                    Count();
                    addRegular();
                    BIKE b=new BIKE(s1,s2, slot);
                }
                else if(getLargeCount()>0){
                    Large slot=new Large(s1);
                    Count();
                    addLarge();
                    BIKE b=new BIKE(s1,s2, slot);
                }
                else{
                    RefuseCount();
                    throw new NoSpaceAvailableException("No Space is Availabe");

                }




            }
            else if (field[0].equals("CAR")) {
                String s1=field[1];
                String s2=field[2];
                if(getRegularCount()>0){
                    Regular slot=new Regular(s1);
                    Count();
                    addRegular();
                    CAR c=new CAR(s1,s2,slot);
                }
                else if(getLargeCount()>0){
                    Large slot=new Large(s1);
                    Count();
                    addLarge();
                    CAR c=new CAR(s1,s2,slot);
                }
                else{
                    RefuseCount();
                    throw new NoSpaceAvailableException("No Space is Availabe");

                }


            }else if (field[0].equals("TRUCK")) {
                String s1=field[1];
                String s2=field[2];
                if(getLargeCount()>0){
                    Large slot=new Large(s1);
                    Count();
                    addLarge();
                    TRUCK t=new TRUCK(s1,s2,slot);
                }
                else{
                    RefuseCount();
                    throw new NoSpaceAvailableException("No Space is Availabe");

                }



            }else if (field[0].equals("PASSTIME")) {
                int hours = Integer.parseInt(field[1]);
                BillingEngine.set(hours);

            }
            else if (field[0].equals("LEAVE")) {

            }
            else if (field[0].equals("FREE")) {
            System.out.println(getBikeCount());
                System.out.println(getRegularCount());
                System.out.println(getLargeCount());

            }
            else if(field[0].equals("SLOT")){

            }
            else if (field[0].equals("EARNED")) {

            }
            else if (field[0].equals("REFUSED")) {
            System.out.println(getRefuseCount());
            }

            // ... one branch per keyword ...
        }
    }
}