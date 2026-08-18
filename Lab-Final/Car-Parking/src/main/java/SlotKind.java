import java.security.interfaces.DSAPublicKey;

public class SlotKind {///
    BIKE(10,5,0);
    REGULAR(30,20,15);
    LARGE(50,40,25);

    public final int firstHour;
    public final int furtherHour;
    public final int surcharge;

    Slotkind(int firstHour, int furtherHour, int surcharge){
        this.firstHour=firstHour;
        this.furtherHour=furtherHour;
        this.surcharge=surcharge;
    }
}
