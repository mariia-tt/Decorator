package ua.ucu.edu.apps.decorator;

public class CashedDocument extends AbstractDecorator {

    public CashedDocument(Document document) {
        super(document);
    }

    @Override
    public String parse() {
        String cached = DBConnection.getInstance()
        .getDocument(getDocument().getGcsPath()); 
        if (cached != null) {
            return cached;
        } else {
            String parsed = getDocument().parse();
            DBConnection.getInstance()
            .createDocument(getDocument().getGcsPath(), parsed); 
            return parsed;
        }
    }

    @Override
    public String getGcsPath() {
        return getDocument().getGcsPath();
    }
}
