
public class Main {
    public static void main(String[] args) {
        Passenger p1 = new Passenger(1, "Ann", 4.09);
        Passenger p2 = new Passenger(2, "Ben");
        Driver    d1 = new Driver(10, "Carl", "A-111");
        Driver    d2 = new Driver(11, "Dana", "B-222");
        Location  l1 = new Location("Start", 0, 0);
        Location  l2 = new Location("End",   3, 4);

        Trip t1 = new Trip(p1, d1, l1, l2, 100.0);
        Trip t2 = new Trip(p2, d2, l2, l1, 200.0);
    }
}
