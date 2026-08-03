package kenakata.order;

    public interface Chargeable { // an interface that can appear on an order bill
        //Any class that implements Chargeable promises to provide concrete implementations for the three methods
        double unitCharge();

        long unitVat();

        String label();
    }
