package kenakata.catalog;

import kenakata.exceptions.NotInsurableException;

public abstract class AddOn implements Chargeable, Insurable{
    @Override
    public boolean returned() {
        return false;
    }

    public void insure() throws NotInsurableException {
        throw new NotInsurableException("No addons can be insured");
    }

    public int insurance() {
        return 0;
    }

    public boolean isInsured() {
        return false;
    }
}
