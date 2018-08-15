package co.yovany.androidtestproject.model;

public class Example {
    private int codeExample;
    private String titleExample;
    private String descriptionExample;
    private String pictureExample;
    private Class classExample;

    public Example(int codeExample, String titleExample, String descriptionExample, String pictureExample, Class classExample) {
        this.codeExample = codeExample;
        this.titleExample = titleExample;
        this.descriptionExample = descriptionExample;
        this.pictureExample = pictureExample;
        this.classExample = classExample;
    }

    public int getCodeExample() {
        return codeExample;
    }

    public void setCodeExample(int codeExample) {
        this.codeExample = codeExample;
    }

    public String getTitleExample() {
        return titleExample;
    }

    public void setTitleExample(String titleExample) {
        this.titleExample = titleExample;
    }

    public String getDescriptionExample() {
        return descriptionExample;
    }

    public void setDescriptionExample(String descriptionExample) {
        this.descriptionExample = descriptionExample;
    }

    public String getPictureExample() {
        return pictureExample;
    }

    public void setPictureExample(String pictureExample) {
        this.pictureExample = pictureExample;
    }

    public Class getClassExample() {
        return classExample;
    }

    public void setClassExample(Class classExample) {
        this.classExample = classExample;
    }
}
