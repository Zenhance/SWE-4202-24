public class CommercialConn extends Connection{
    public CommercialConn(double units){
        this.energy=units;
        this.fixed=500;
        this.fuelPet=0.08;
        this.taxPet=0.12;
    }

    @Override
    public double energyCharge(){
        if(energy<=200){
            return energy*6;

        }
        else{
            return 200*6 + (energy-200)*8;
        }
    }
    @Override
    public double fixedCharge(){
        return fixed;
    }

}
