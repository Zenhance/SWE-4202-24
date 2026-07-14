public class Industrial extends Bill{
    private static final double RATE = 18.50;
    private static final double FIXED_CHARGE = 2000.0;

    public Industrial(int previousReading,int currentReading){
        super(previousReading,currentReading);
    }
    @Override
    public double calculateBill(){
        int units=getUnitsConsumed();
    }
    double energyCharge=units*RATE;
            double fuelCharge=energyCharge*getFuelPercent();
            return FIXED_CHARGE+energyCharge+fuelCharge;
}
