package co.yovany.androidtestproject.model;

public class Student {

    int codeStudent;
    String NameStudent;
    String IdStudent;
    int missingExcuseStudent;
    int missingStudent;
    int totalMissingStudent;
    String avatarStudent;

    public Student(int codeStudent, String nameStudent, String idStudent, int missingExcuseStudent, int missingStudent, int totalMissingStudent, String avatarStudent) {
        this.codeStudent = codeStudent;
        NameStudent = nameStudent;
        IdStudent = idStudent;
        this.missingExcuseStudent = missingExcuseStudent;
        this.missingStudent = missingStudent;
        this.totalMissingStudent = totalMissingStudent;
        this.avatarStudent = avatarStudent;
    }

    public int getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(int codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return NameStudent;
    }

    public void setNameStudent(String nameStudent) {
        NameStudent = nameStudent;
    }

    public String getIdStudent() {
        return IdStudent;
    }

    public void setIdStudent(String idStudent) {
        IdStudent = idStudent;
    }

    public int getMissingExcuseStudent() {
        return missingExcuseStudent;
    }

    public void setMissingExcuseStudent(int missingExcuseStudent) {
        this.missingExcuseStudent = missingExcuseStudent;
    }

    public int getMissingStudent() {
        return missingStudent;
    }

    public void setMissingStudent(int missingStudent) {
        this.missingStudent = missingStudent;
    }

    public int getTotalMissingStudent() {
        return totalMissingStudent;
    }

    public void setTotalMissingStudent(int totalMissingStudent) {
        this.totalMissingStudent = totalMissingStudent;
    }

    public String getAvatarStudent() {
        return avatarStudent;
    }

    public void setAvatarStudent(String avatarStudent) {
        this.avatarStudent = avatarStudent;
    }
}
