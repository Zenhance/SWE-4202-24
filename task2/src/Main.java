public class Main {
    public static void main(String[] args) {
        StudentStack s1 = new StudentStack();

        s1.push("ShinChan",99);
        s1.push("Melody",97);
        s1.push("Hehe",92);
        s1.push("Kuromi",98);
        s1.push("LeeMinHo",96);

        s1.peek();

        s1.pop();
        s1.pop();
        s1.pop();

        s1.display();
        s1.display();
        s1.display();
        s1.display();
        s1.display();

    }
}