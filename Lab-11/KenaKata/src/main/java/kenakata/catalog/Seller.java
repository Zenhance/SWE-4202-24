package kenakata.catalog;

public class Seller {
private String name;
 public Seller (String name)
 {
     if(name==null || name.isBlank())

         throw new IllegalArgumentException("Name can not be Null");
this.name= name;




 }
public String name()
{
    return name;

}
@Override
    public String toString()
{
    return name;
}








}
