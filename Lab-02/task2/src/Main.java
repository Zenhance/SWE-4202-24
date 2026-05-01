public class Main {
    public static void main(String[] args){
        StudentStack s= new StudentStack(5);

        s.push(new Student("Alice", 80) );
        s.push(new Student("Bob", 90) );
        s.push(new Student("Alpha", 70) );
        s.push(new Student("Beta", 50) );
        s.push(new Student("Gamma", 60) );

        // popping the students
        s.pop();
        s.pop();
        s.pop();


        Student topstudent=s.peek();
        System.out.println(topstudent.name+"--"+topstudent.mark);

        s.display();






    }
}
