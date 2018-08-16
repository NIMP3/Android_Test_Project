package co.yovany.androidtestproject.model;

public class Task {

    private int code;
    private long date;
    private String type;

    public Task(int code, String type) {
        this.code = code;
        this.date = System.currentTimeMillis();
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getDate() {
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
