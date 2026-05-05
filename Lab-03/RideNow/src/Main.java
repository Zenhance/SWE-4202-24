//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Location airport = new Location("Airport", 3.0, 7.5);

        System.out.println("This is label: " + airport.getLabel());
        System.out.println("This is x co-ordinate: " + airport.getX());
        System.out.println("This is y co-ordinate: " + airport.getY());
        System.out.println("This is  address: " + airport.toString());

        Location iut = new Location(0.0, 0.0);

        System.out.println("This is distance from IUT: " + airport.distanceTo(iut));

    }
}