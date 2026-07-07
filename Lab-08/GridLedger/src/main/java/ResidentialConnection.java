public class ResidentialConnection extends Connection {

    public double energyCharge(){
        int units = meter.getUnitsConsumed();

        if(units <= 50){
            return units * 4.0;
        }
        if(units <= 200){
            return 50 * 4.0 + (units - 50) * 7.0;
        }
        return 50 * 4.0 + (units - 50) * 7.0 +  (units - 200) * 11.0;
    }

    public double fixedCharge(){
        return 100.0;
    }



}
