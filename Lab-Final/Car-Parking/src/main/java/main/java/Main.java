package main.java;

import javax.xml.validation.Schema;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ParkingLot parkingLot = new ParkingLot(1,2,1,10);
        try{
            Scheme  nodis = new NoDis();
            Bike bike1 = new Bike("DH-11-2233", nodis);
            Bike bike2 = new Bike("DH-11-0009", nodis);
            parkingLot.parkVehicle(bike1);
            parkingLot.parkVehicle(bike2);
            System.out.println("Vehicles parked successfully");

        }
        catch (NoPlateException | NoSlotException e) {

            parkingLot.addRefusal();
            System.out.println(e.getMessage());
        }


    }
}