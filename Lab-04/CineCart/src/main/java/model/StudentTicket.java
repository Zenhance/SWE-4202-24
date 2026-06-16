package model;

public class StudentTicket extends AbstractTicket {

    private int id;
    private int studentId;

    public StudentTicket() {
        this.id = 0;
        this.studentId = 0;
    }
    public StudentTicket(int id, int studentId) {
        this.id = id;
        this.studentId = studentId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    @Override
    public String toString() {
        return "StudentTicket{" + "id=" + id + ", studentId=" + studentId + '}';
    }

}
