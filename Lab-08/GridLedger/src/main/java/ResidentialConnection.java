package main.java;

import java.util.Stack;

public class ResidentialConnection extends Connection {
    private static final double Res_Rate_1=4.0;
    private static final double Res_Rate_2=7.0;
    private static final double Res_rate_3=11.0;
    private static final double Res_Fixed=100.0;

    public ResidentialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge() {
        int unit= getMeter().getUnitConsumed();
        if(unit<=50){
            return Res_Rate_1;
        }
        else if(unit>50 && unit<=200){
            return 50*Res_Rate_1+(unit-50)*Res_Rate_2;
        }
        else{
            return 50*Res_Rate_1+150*Res_Rate_2+(unit-200)*Res_rate_3;
        }
    }

    @Override
    public double fixedCharge() {
        return Res_Fixed;
    }
}
