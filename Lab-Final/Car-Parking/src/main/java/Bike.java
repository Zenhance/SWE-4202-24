import static java.lang.Math.max;
public class Bike extends Slot{
    protected static int bikeSlot=0;
    Bike(String numPlate, String Scheme) {
        super(numPlate, Scheme);
        bikeSlot++;
    }



    Bike(String numPlate) {
        super(numPlate);
        bikeSlot++;

    }
    @Override
    protected void fee() {
        int x=10+5*PASSTIME;
        if(student){
            x=x-(20*x/100);
            bikeBill=x;
        }
        else if(weekend){
            x=max(0,x-100);
            bikeBill= x;
        }
        else {
            bikeBill= x;
        }
    }
    public static void free(){
        bikeSlot--;
        count--;
    }


    @Override
    protected void leave() {
        bikeSlot--;
        count--;
    }

    public static int getBikeSlot() {
        return bikeSlot;
    }
}
