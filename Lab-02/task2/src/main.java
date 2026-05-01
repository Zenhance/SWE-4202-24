public class main {
    public static void main(String[] args) {
        StudentStack stack=new StudentStack();
        stack.push("Sadman",86);
        stack.push("Raiyan",78);
        stack.push("Syed",87);
        stack.push("Baba",88);
        stack.push("Naz",67);

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();


    }
}
