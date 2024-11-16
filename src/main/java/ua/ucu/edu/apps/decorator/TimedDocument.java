package ua.ucu.edu.apps.decorator;

import java.time.LocalTime;
import java.time.Duration;

public class TimedDocument extends AbstractDecorator {

    public TimedDocument(Document document) {
        super(document);
    }

    @Override
    public String parse() {
        LocalTime startTime = LocalTime.now();
        String parsed = getDocument().parse();
        LocalTime endTime = LocalTime.now();
        System.out.println("Time: "
         + Duration.between(startTime, endTime).getSeconds());

        return parsed;
    }

    @Override
    public String getGcsPath() {
        return getDocument().getGcsPath();
    }
}
