import static java.lang.Math.max;

public class Regular extends Slot{
    private static int regularSlot=0;


    Regular(String numPlate, String Scheme) {
        super(numPlate, Scheme);
        regularSlot++;
    }
    Regular(String numPlate) {
        super(numPlate);
        regularSlot++;
    }


    @Override
    protected void fee() {

        int x=30+20*PASSTIME;
        if(surchargable){
            x=x+15;
        }
        if(student){
            x=x-(20*x/100);
            reglarBill=x;
        }
        else if(weekend){
            x=max(0,x-100);
            reglarBill=x;
        }
        else {
            reglarBill=x;
        }
    }

    public int getReglarBill(){
        return reglarBill;
    }

    public static void free(){
        regularSlot--;
        count--;
    }

    @Override
    protected void leave() {
        count--;
        regularSlot--;
    }

    public static int getRegularSlot() {
        return regularSlot;
    }
}
