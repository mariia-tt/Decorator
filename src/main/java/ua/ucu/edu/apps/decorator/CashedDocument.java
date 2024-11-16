package ua.ucu.edu.apps.decorator;

public class CashedDocument extends AbstractDecorator {

    public CashedDocument(Document document) {
        super(document);
    }

    @Override
    public String parse() {
        String cached = DBConnection.getInstance().getDocument(document.getGcsPath());
        if (cached != null) {
            return cached;
        } else {
            String parsed = document.parse();
            DBConnection.getInstance().createDocument(document.getGcsPath(), parsed);
            return parsed;
        }

    }

    @Override
    public String getGcsPath() {
        return document.getGcsPath();
    }
    
}
