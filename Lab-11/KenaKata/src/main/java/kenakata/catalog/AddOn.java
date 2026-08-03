package kenakata.catalog;

public abstract class AddOn implements Chargeable{
    @Override
    public boolean returned() {
        return false;
    }
}