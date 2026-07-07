public class IndustrialConn extends Connection{
    public IndustrialConn(double units){
        this.energy=units;
        this.fixed=2000;
        this.fuelPet=0.10;
        this.taxPet=0.15;
    }

    @Override
    public double energyCharge(){
        return energy*15;
    }

    @Override
    public double fixedCharge(){
        return fixed;
    }

}
