public class Student {
    private String name;
    private int ID;
    private double cgpa;

    public Student(String name, int ID, double cgpa) {
        this.name = name;
        this.ID = ID;
        this.cgpa = cgpa;
    }

    public String toString() {
        return ID +"  " + name +"  "+ cgpa;
    }
}
