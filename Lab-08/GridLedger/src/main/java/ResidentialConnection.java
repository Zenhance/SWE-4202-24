public class ResidentialConnection extends Connection{
    public ResidentialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge() {
        int units=getUnitsConsumed();
        if(units<=50){
            return units*4.0;
        }else if(units<=200){
            return 50*4+(units-50)*7;
        }
        else {
            return 50*4+ 150 * 7+ (units - 200) * 11;
        }
    }

    @Override
    public double fixedCharge() {
        return 100;
    }
}
