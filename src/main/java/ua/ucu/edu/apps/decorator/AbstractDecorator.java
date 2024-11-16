package ua.ucu.edu.apps.decorator;

public abstract class AbstractDecorator implements Document {
    protected Document document;

    public AbstractDecorator(Document document) {
        this.document = document;
    }

    @Override
    public String getGcsPath() {
        return document.getGcsPath();
    }
}
