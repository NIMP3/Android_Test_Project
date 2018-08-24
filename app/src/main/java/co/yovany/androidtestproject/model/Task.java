package co.yovany.androidtestproject.model;

public class Task {

    private int code;
    private float date;
    private String type;

    public Task(int code, String type, float date) {
        this.code = code;
        this.date = date;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
