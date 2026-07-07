public class CommercialConnection extends Connection{

    CommercialConnection(Meter meter) {
        super(meter);
    }

    public double energyCharge(){
        int units = getUnits();
        if(units <= 100){
            return units * 9.0;
        }
        return 100 * 9.0 + (units - 100) * 13.0;
    }

    public double fixedCharge(){
        return 500.0;
    }


}
