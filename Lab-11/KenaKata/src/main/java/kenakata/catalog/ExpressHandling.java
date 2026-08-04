package kenakata.catalog;

public class ExpressHandling implements Chargeable{
    @Override

    public long unitCharge(){
        return 120;}
    @Override
    public long unitVat(){
  return  (long)Math.ceil(unitCharge()*(0.75*0.01));
    }}
