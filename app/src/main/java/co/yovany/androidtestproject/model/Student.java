package co.yovany.androidtestproject.model;

public class Student {

    private int code;
    private String name;
    private String id;
    private String avatar;

    public Student(int code, String name, String id, String avatar) {
        this.code = code;
        this.name = name;
        this.id = id;
        this.avatar = avatar;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
