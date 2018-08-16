package co.yovany.androidtestproject.model;

public class Note {

    private int code;
    private double value;
    private int task;
    private int student;

    public Note(int code, double value, int task, int student) {
        this.code = code;
        this.value = value;
        this.task = task;
        this.student = student;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }
}
