package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyatyTier="BASIC";

    Customer(int id, String name, int age) {
        this.id=id;
        this.name=name;
        this.age=age;
    }
}
