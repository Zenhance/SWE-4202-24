package kenakata.catalog;

import kenakata.exceptions.NotInsurableException;

public interface Insurable {
    int insurance();
    void insure() throws NotInsurableException;
    boolean isInsured();
}
