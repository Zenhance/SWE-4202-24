package main.java;

import javax.xml.validation.Schema;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot(1,2,1,10);
        Scheme nodis = new NoDis();
        Scheme studentdis = new StudentDis();
        Bike bike = new Bike("DH-11-2233", nodis);
        Car car = new Car("DH-14-5678", studentdis);
        Truck truck = new Truck("CT-19-0001", nodis);
        try{
            parkingLot.parkVehicle(bike);
            parkingLot.parkVehicle(car);
            parkingLot.parkVehicle(truck);
            System.out.println("Bike: " + parkingLot.getVehicleSlot("DH-11-2233"));
            System.out.println("Car: " + parkingLot.getVehicleSlot("DH-14-5678"));
            System.out.println("Truck: " + parkingLot.getVehicleSlot("CT-19-0001"));
            System.out.println("Vehicle count: " + parkingLot.getvehiclecount());
        }
        catch (NoPlateException | NoSlotException e) {
            parkingLot.addRefusal();
            System.out.println(e.getMessage());
        }


    }
}