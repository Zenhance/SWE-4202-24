package kenakata.catalog;

import kenakata.exceptions.ReturnNotAllowedException;

public interface Returnable {
    void returnProduct(int dayOfPlacement, int dayOfReturn) throws ReturnNotAllowedException;
    boolean isReturnable();
}
