package model;
public class customer{
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    public customer(int id;String name;int age){
    this.id=id;
    this.name=name;
    this.age=age;
    this.loyaltyTier=loyaltyTier;}

    public int geId(){
        return name;}
    public int getAge{
        return age;}
    public String getLoyaltyTier() {
        return loyaltyTier;
    }

    public double getTierDiscount(){
        if(loyaltyTier.equals("Gold")){
            return 0.15;}
        else if(loyaltyTier.equals("Silver")){
            return 0.08}
        else{
            return 0.00;}
        }

      public Srting toString(){
        return string.format("%s(%s)",name,loyaltyTier);}

}
