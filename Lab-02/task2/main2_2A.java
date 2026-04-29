public class main2_2A {
    public static void main(String[] args) {
        StudentStack roster = new StudentStack();

        roster.push("rey", 99);
        roster.push("miya", 78);
        roster.push("ted", 76);
        roster.push("beyhive", 56);
        roster.push("ryad", 100);
        System.out.println();

        roster.peek();
        System.out.println();

        roster.pop();
        roster.pop();
        roster.pop();
        System.out.println();

        roster.display();
        System.out.println();
    }
}
