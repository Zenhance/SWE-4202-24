import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarPark {

    private final List<ParkingSlot> slots = new ArrayList<>();
    private final Map<String, Vehicle> vehicles = new HashMap<>();

    private int maxStay;
    private int refused;
    private long earned;

    public CarPark(int bike, int regular, int large) {

        addSlots("BIKE", bike);
        addSlots("REGULAR", regular);
        addSlots("LARGE", large);
    }

    private void addSlots(String type, int number) {

        for (int i = 0; i < number; i++) {
            slots.add(new ParkingSlot(type));
        }
    }

    public void setMaxStay(int maxStay) {
        this.maxStay = maxStay;
    }



    public void addVehicle(Vehicle vehicle)
            throws NoPlateException, NoSlotException {


        if (vehicle.getPlate().equals("-")) {
            throw new NoPlateException();
        }

        for (String type : vehicle.acceptableSlots()) {

            for (ParkingSlot slot : slots) {

                if (slot.getType().equals(type)
                        && slot.isFree()) {

                    slot.park(vehicle);

                    vehicles.put(
                            vehicle.getPlate(),
                            vehicle
                    );

                    return;
                }
            }
        }


        throw new NoSlotException();
    }



    public long bill(String plate)
            throws VehicleNotFoundException {

        Vehicle vehicle = vehicles.get(plate);

        // Refusal 3
        if (vehicle == null) {
            throw new VehicleNotFoundException();
        }

        return calculateBill(
                vehicle,
                vehicle.getHours()
        );
    }

    private long calculateBill(
            Vehicle vehicle,
            int hours) {


        hours = Math.max(1, hours);

        long bill;

        switch (vehicle.getSlot().getType()) {

            case "BIKE":
                bill = 10 + (hours - 1L) * 5;
                break;

            case "REGULAR":
                bill = 30 + (hours - 1L) * 20;
                break;

            default:
                bill = 50 + (hours - 1L) * 40;
        }


        if (!vehicle.getSlot().getType()
                .equals(vehicle.belongsIn())) {

            if (vehicle.getSlot().getType()
                    .equals("REGULAR")) {

                bill += 15;

            } else {

                bill += 25;
            }
        }


        if (vehicle.getScheme().equals("STUDENT")) {

            bill = bill * 80 / 100;

        } else if (vehicle.getScheme().equals("WEEKEND")) {

            bill = Math.max(0, bill - 10);
        }

        return bill;
    }


    public void leave(String plate)
            throws VehicleNotFoundException {

        Vehicle vehicle = vehicles.get(plate);

        if (vehicle == null) {
            throw new VehicleNotFoundException();
        }

        earned += calculateBill(
                vehicle,
                vehicle.getHours()
        );

        remove(vehicle);
    }

    private void remove(Vehicle vehicle) {

        vehicle.getSlot().free();

        vehicles.remove(
                vehicle.getPlate()
        );
    }



    public void passTime(int hours) {

        for (Vehicle vehicle : vehicles.values()) {
            vehicle.addHours(hours);
        }


        for (Vehicle vehicle :
                new ArrayList<>(vehicles.values())) {

            if (vehicle.getHours() >= maxStay) {
                evict(vehicle);
            }
        }
    }



    private void evict(Vehicle vehicle) {

        int extra = (maxStay + 9) / 10;

        earned += calculateBill(
                vehicle,
                maxStay + extra
        );

        remove(vehicle);
    }



    public String slot(String plate)
            throws VehicleNotFoundException {

        Vehicle vehicle = vehicles.get(plate);

        if (vehicle == null) {
            throw new VehicleNotFoundException();
        }

        return vehicle.getSlot().getType();
    }

    public int free(String type) {

        int count = 0;

        for (ParkingSlot slot : slots) {

            if (slot.getType().equals(type)
                    && slot.isFree()) {

                count++;
            }
        }

        return count;
    }


    public int count() {
        return vehicles.size();
    }

    public long earned() {
        return earned;
    }


    public int refused() {
        return refused;
    }

    public void addRefusal() {
        refused++;
    }
}