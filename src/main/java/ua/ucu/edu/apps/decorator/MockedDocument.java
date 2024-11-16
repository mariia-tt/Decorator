package ua.ucu.edu.apps.decorator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MockedDocument implements Document {

    private String gcsPath;

    private static final int SLEEP_TIME = 2000;

    @Override
    public String parse() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Mocked Document Parse";
    }
}
