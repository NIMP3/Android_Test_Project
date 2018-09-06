package co.yovany.androidtestproject.model;

import io.realm.RealmObject;

public class Developer extends RealmObject{

    private int code;
    private String name;

    public Developer() {}

    public Developer(int code, String name) {
        this.code = code;
        this.name = name;
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
}
