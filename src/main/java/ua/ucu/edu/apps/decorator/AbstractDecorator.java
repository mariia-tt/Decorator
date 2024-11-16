package ua.ucu.edu.apps.decorator;

import lombok.Getter;

@Getter
public abstract class AbstractDecorator implements Document {
    private Document document;

    public AbstractDecorator(Document document) {
        this.document = document;
    }

    @Override
    public String getGcsPath() {
        return document.getGcsPath();
    }
}
