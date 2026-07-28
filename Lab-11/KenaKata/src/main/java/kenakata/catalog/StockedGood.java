package kenakata.catalog;
package kenakata.exceptions.*;

public class StockedGood extends FreshGood {
    public StockedGood(java.lang.String string, java.lang.String tableLamp, int i, int i1, Seller s, int i2) {
    }

    public int unitCharge() {
    }

    public int unitVat() {
    }

    public int commissionOn(int i) {
    }

    public void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException();
        }

        if (quantity > stock) {
            throw new OutOfStockException("Not enough stock");
        }

        stock -= quantity;
    }

    public int remaining() {
        return 0;
    }
}
