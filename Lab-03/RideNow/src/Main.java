public class Main {

    public static void main(String[] args) {
        Passenger sleepyCoder =
                new Passenger(42, "Alice", 4.8);
        Driver nightOwl =
                new Driver(7, "Bob", "DHA-1234");
        Location spawnPoint =
                new Location("Airport", 3.0, 7.5);
        Location finalBossArena =
                new Location("University", 8.0, 4.0);
        Trip chaosRide = new Trip(sleepyCoder, nightOwl, spawnPoint, finalBossArena, 50.0);
        System.out.println(chaosRide.getSummary());
        System.out.println();
        chaosRide.completeTrip();
        System.out.println(chaosRide.getSummary());
    }
}