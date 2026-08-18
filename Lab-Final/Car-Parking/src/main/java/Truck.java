import static java.lang.Math.max;
public class Truck extends Slot{
    protected static int truckSlot=0;
    Truck(String numPlate, String Scheme) {
        super(numPlate, Scheme);
        truckSlot++;
    }



    Truck(String numPlate) {
        super(numPlate);
truckSlot++;
    }
    @Override
    protected void fee() {
        int x=50+40*PASSTIME;
        if(surchargable){
            x=x+25;
        }
        if(student){
            x=x-(20*x/100);
            truckBill=x;
        }
        else if(weekend){
            x=max(0,x-100);
            truckBill= x;
        }
        else {
            truckBill= x;
        }
    }
    public static void free(){
        truckSlot--;
        count--;
    }

    @Override
    protected void leave() {
        truckSlot--;
        count--;
    }

    public static int getTruckSlot() {
        return truckSlot;
    }
}
