public class one{
    public static void main(String[] args)
    {
        Student s1 = new Student();         // Copy / Object / Instance
        Student s2 = new Student();         // Copy / Object / Instance

        System.out.println("");
        System.out.println("main: " + s1);
        System.out.println("main: " + s2);
        System.out.println("");
        s1.fn();
        s2.fn();
    }
}



/* This is BluePrint */
class Student {
    String name = "ayiham";
    int ID = 569;
    String uniName = "IUT";

    void fn() {
        System.out.println("fn1:  " + this);

        System.out.println("Hello World");
        System.out.println(name);
        System.out.println(ID);
        System.out.println(uniName);
        System.out.println("\n==========\n");
    }
}




