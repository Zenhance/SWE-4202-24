package kenakata.catalog;

public class Seller {
    package kenakata.settlement;


        private final Seller seller;
        private long grossSales;
        private long commission;
        private long refunds;

        public SellerPayout(seller seller){
            this.seller = seller;
        }
        public void addSales(long amount){
            this.grossSales += amount;
        }

        public void addCommission(long amount){
            this.commission += amount;
        }

        public void addRefund(long amount){
            this.refunds += amount;
        }
        public long grossSales(){
            return grossSales;
        }
        public long commission(){
            return commission;
        }
        public long refunds(){
            return refunds;
        }
        public long payout(){
            return grossSales - commission - refunds;
        }
    }
