package kenakata.catalog;
import java.util.Objects;

public class Seller {
    private final String name;
    public Seller(String name){
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Incorrect Input");
        }
        this.name=name;
    }

    public String name(){
        return name;
    }

    public String toString(){
        return name;
    }

    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Seller other)){
            return false;
        }
        return Objects.equals(name,other.name);
    }

    public int hashCode(){
        return Objects.hash(name);
    }
}
