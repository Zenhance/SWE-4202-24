package model;

public class Customer {

    private int id;
    private String name;
    private int age;
    private String tier;

    public Customer(int id, String name, int age, String tier) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tier = tier;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTier() {
        return tier;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", tier=" + tier + "]";
    }
}