import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarPark {

    private final SlotManager slotManager;
    private final BillingService billingService;
    private final EvictionService evictionService;

    private final Map<String, Vehicle> vehicles;

    private int maxStay;
    private int earnings;
    private int refused;

    public CarPark() {

        slotManager = new SlotManager();
        billingService = new BillingService();
        evictionService = new EvictionService(billingService);

        vehicles = new LinkedHashMap<>();

        maxStay = 0;
        earnings = 0;
        refused = 0;
    }


    public void initializeSlots(
            int bikeSlots,
            int regularSlots,
            int largeSlots) {

        slotManager.initialize(
                bikeSlots,
                regularSlots,
                largeSlots
        );
    }

    public void setMaxStay(int maxStay) {
        this.maxStay = maxStay;
    }


    public void arrive(Vehicle vehicle) throws ParkingException {

        validatePlate(vehicle.getPlate());

        if (vehicles.containsKey(vehicle.getPlate())) {
            throw new ParkingException(
                    "Plate is already in the park"
            );
        }

        ParkingSlot slot = slotManager.findSlot(vehicle);

        if (slot == null) {
            throw new NoSlotException();
        }

        slotManager.park(vehicle, slot);

        vehicles.put(vehicle.getPlate(), vehicle);
    }

    private void validatePlate(String plate)
            throws EmptyPlateException {

        if (plate == null ||
                plate.isBlank() ||
                plate.equals("-")) {

            throw new EmptyPlateException();
        }
    }

    public void leave(String plate)
            throws VehicleNotFoundException {

        Vehicle vehicle = getVehicle(plate);

        int bill = billingService.calculate(vehicle);

        earnings += bill;

        removeVehicle(vehicle);
    }

    public int getBill(String plate)
            throws VehicleNotFoundException {

        Vehicle vehicle = getVehicle(plate);

        return billingService.calculate(vehicle);
    }

    public SlotType getSlotType(String plate)
            throws VehicleNotFoundException {

        Vehicle vehicle = getVehicle(plate);

        if (vehicle.getParkingSlot() == null) {
            return null;
        }

        return vehicle.getParkingSlot().getType();
    }

    public int getFreeSlots(SlotType type) {
        return slotManager.freeCount(type);
    }

    public int getVehicleCount() {
        return vehicles.size();
    }

    public int getEarnings() {
        return earnings;
    }

    public int getRefused() {
        return refused;
    }

    public void incrementRefused() {
        refused++;
    }

    public void passTime(int hours) {


        for (int i = 0; i < hours; i++) {


            Collection<Vehicle> currentVehicles =
                    new java.util.ArrayList<>(vehicles.values());

            for (Vehicle vehicle : currentVehicles) {

                vehicle.addHour();

                if (vehicle.getParkedHours() >= maxStay) {

                    evict(vehicle);
                }
            }
        }
    }

    private void evict(Vehicle vehicle) {

        int bill = evictionService.evictionBill(
                vehicle,
                maxStay
        );

        earnings += bill;

        removeVehicle(vehicle);
    }

    private void removeVehicle(Vehicle vehicle) {

        ParkingSlot slot = vehicle.getParkingSlot();

        if (slot != null) {
            slotManager.free(slot);
        }

        vehicles.remove(vehicle.getPlate());
    }
    private Vehicle getVehicle(String plate)
            throws VehicleNotFoundException {

        Vehicle vehicle = vehicles.get(plate);

        if (vehicle == null) {
            throw new VehicleNotFoundException(plate);
        }

        return vehicle;
    }
}