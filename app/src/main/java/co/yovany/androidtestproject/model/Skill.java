package co.yovany.androidtestproject.model;

import io.realm.RealmObject;

public class Skill extends RealmObject {

    private int developerCode;
    private String name;
    private float score;
    private float scoreNumber;

    public Skill() {}

    public Skill(int developerCode, String name, float score, float scoreNumber) {
        this.developerCode = developerCode;
        this.name = name;
        this.score = score;
        this.scoreNumber = scoreNumber;
    }

    public int getDeveloperCode() {
        return developerCode;
    }

    public void setDeveloperCode(int developerCode) {
        this.developerCode = developerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getScoreNumber() {
        return scoreNumber;
    }

    public void setScoreNumber(float scoreNumber) {
        this.scoreNumber = scoreNumber;
    }
}
