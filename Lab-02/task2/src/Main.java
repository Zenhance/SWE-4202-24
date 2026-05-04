public class Main {
    public static void main(String[] args) {
        StudentStack students = new StudentStack(5);

        students.push(new Student("Rakin", 85));
        students.push(new Student("Zunied", 92));
        students.push(new Student("Sakib", 91));
        students.push(new Student("Noor", 55));
        students.push(new Student("Omi", 67));

        students.pop();
        students.pop();
        students.pop();


        Student topstudent = students.peek();
        System.out.println(topstudent.name + "--" + topstudent.marks);

        students.display();
    }
}
