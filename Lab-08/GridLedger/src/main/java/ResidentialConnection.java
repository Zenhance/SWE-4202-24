public abstract class ResidentialConnection extends Connection{
    private static final double res_rate1=4.0;
    private static final double res_rate2=7.0;
    private static final double res_rate3=11.0;
    private static final double res_rate=100.0;


    public ResidentialConnection(Meter meter) {
        super(meter);
    }
    @Override
    public double energyCharge(){
        Meter meter = getMeter();
        int unit= meter.getUnitsConsumed();
        if(unit<50){
            return unit*res_rate1;
        }
        if(unit>=50 && unit <=200){
            return 50*res_rate1+(unit-50)*res_rate2;
        }
        else {
            return 50*res_rate1+150*res_rate2+(unit-200)*res_rate3;
        }
    }

    @Override
    public double fixedCharge() {
        return res_rate;
    }
}
