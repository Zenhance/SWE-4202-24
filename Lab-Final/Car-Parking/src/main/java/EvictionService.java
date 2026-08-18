import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EvictionService {

    private final BillingService billingService;

    public EvictionService(BillingService billingService) {
        this.billingService = billingService;
    }

    public List<Vehicle> findVehiclesToEvict(
            Collection<Vehicle> vehicles,
            int maxStay) {

        List<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getParkedHours() >= maxStay) {
                result.add(vehicle);
            }
        }

        return result;
    }
    public int evictionBill(Vehicle vehicle, int maxStay) {

        return billingService.calculateEvictionBill(
                vehicle,
                maxStay
        );
    }
}