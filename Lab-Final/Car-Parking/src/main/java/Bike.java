import static java.lang.Math.max;
public class Bike extends Slot{
    Bike(String numPlate, String Scheme) {
        super(numPlate, Scheme);
    }



    Bike(String numPlate) {
        super(numPlate);
    }
    @Override
    protected int fee() {
        int x=10+5*PASSTIME;
        if(student){
            x=x-(20*x/100);
            return x;
        }
        else if(weekend){
            x=max(0,x-100);
            return x;
        }
        else {
            return x;
        }
    }

}
