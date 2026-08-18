import java.security.interfaces.DSAPublicKey;

public enum SlotKind {///
    BIKE(10,5,0),
    REGULAR(30,20,15),
    LARGE(50,40,25);

    final int firstHour;
    final int furtherHour;
    final int surcharge;

    SlotKind(int surcharge, int furtherHour, int firstHour){
        this.firstHour=firstHour;
        this.furtherHour=furtherHour;
        this.surcharge=surcharge;
    }
}
