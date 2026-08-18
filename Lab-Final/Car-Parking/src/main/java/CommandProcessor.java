public class CommandProcessor {

    private final CarPark carPark;

    public CommandProcessor(CarPark carPark) {
        this.carPark = carPark;
    }

    public void process(String line) {

        if (line == null || line.isBlank()) {
            return;
        }

        String[] parts = line.trim().split("\\s+");

        String command = parts[0];

        try {

            switch (command) {

                case "SLOTS":
                    processSlots(parts);
                    break;

                case "MAXSTAY":
                    processMaxStay(parts);
                    break;

                case "BIKE":
                    processBike(parts);
                    break;

                case "CAR":
                    processCar(parts);
                    break;

                case "TRUCK":
                    processTruck(parts);
                    break;

                case "PASSTIME":
                    processPassTime(parts);
                    break;

                case "LEAVE":
                    processLeave(parts);
                    break;

                case "BILL":
                    processBill(parts);
                    break;

                case "SLOT":
                    processSlot(parts);
                    break;

                case "FREE":
                    processFree(parts);
                    break;

                case "COUNT":
                    System.out.println(carPark.getVehicleCount());
                    break;

                case "EARNED":
                    System.out.println(carPark.getEarnings());
                    break;

                case "REFUSED":
                    System.out.println(carPark.getRefused());
                    break;

                case "END":
                    break;

                default:
                    break;
            }

        } catch (ParkingException e) {

            carPark.incrementRefused();
        }
    }


    private void processSlots(String[] parts) {

        int bike = Integer.parseInt(parts[1]);
        int regular = Integer.parseInt(parts[2]);
        int large = Integer.parseInt(parts[3]);

        carPark.initializeSlots(
                bike,
                regular,
                large
        );
    }


    private void processMaxStay(String[] parts) {

        int maxStay = Integer.parseInt(parts[1]);

        carPark.setMaxStay(maxStay);
    }

    private void processBike(String[] parts)
            throws ParkingException {

        String plate = parts[1];
        SchemeType scheme = SchemeType.fromString(parts[2]);

        DiscountScheme discount =
                DiscountFactory.create(scheme);

        Vehicle vehicle =
                new Motorcycle(plate, discount);

        carPark.arrive(vehicle);
    }

    private void processCar(String[] parts)
            throws ParkingException {

        String plate = parts[1];
        SchemeType scheme = SchemeType.fromString(parts[2]);

        DiscountScheme discount =
                DiscountFactory.create(scheme);

        Vehicle vehicle =
                new Car(plate, discount);

        carPark.arrive(vehicle);
    }

    private void processTruck(String[] parts)
            throws ParkingException {

        String plate = parts[1];
        SchemeType scheme = SchemeType.fromString(parts[2]);

        DiscountScheme discount =
                DiscountFactory.create(scheme);

        Vehicle vehicle =
                new Truck(plate, discount);

        carPark.arrive(vehicle);
    }

    private void processPassTime(String[] parts) {

        int hours = Integer.parseInt(parts[1]);

        carPark.passTime(hours);
    }
    private void processLeave(String[] parts)
            throws VehicleNotFoundException {

        String plate = parts[1];

        carPark.leave(plate);
    }

    private void processBill(String[] parts) {

        String plate = parts[1];

        try {
            int bill = carPark.getBill(plate);
            System.out.println(bill);
        } catch (VehicleNotFoundException e) {
            System.out.println("NONE");
        }
    }

    private void processSlot(String[] parts) {

        String plate = parts[1];

        try {
            SlotType type = carPark.getSlotType(plate);

            if (type == null) {
                System.out.println("NONE");
            } else {
                System.out.println(type);
            }
        } catch (VehicleNotFoundException e) {
            System.out.println("NONE");
        }
    }

    private void processFree(String[] parts) {

        SlotType type =
                SlotType.valueOf(parts[1]);

        int count =
                carPark.getFreeSlots(type);

        System.out.println(count);
    }
}