package kenakata.order;

    public interface Chargeable {
        double unitCharge();

        long unitVat();

        String label();
    }
