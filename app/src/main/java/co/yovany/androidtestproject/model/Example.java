package co.yovany.androidtestproject.model;

public class Example {
    private int codeExample;
    private String titleExample;
    private String descriptionExample;
    private String pictureExample;

    public Example(int codeExample, String titleExample, String descriptionExample, String pictureExample) {
        this.codeExample = codeExample;
        this.titleExample = titleExample;
        this.descriptionExample = descriptionExample;
        this.pictureExample = pictureExample;
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
}
