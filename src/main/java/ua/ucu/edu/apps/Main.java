package ua.ucu.edu.apps;

import ua.ucu.edu.apps.decorator.DBConnection;
import ua.ucu.edu.apps.decorator.MockedDocument;
import ua.ucu.edu.apps.decorator.TimedDocument;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");

        MockedDocument mockedDocument = new MockedDocument("path");
        TimedDocument timedDocument = new TimedDocument(mockedDocument);
        DBConnection.getInstance().checkConnection(); 
        System.out.println(timedDocument.parse());
        
    }
}
