package Lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import Lab3.classes.Watermeter;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String args[]) throws IOException {
        Watermeter watermeter = Watermeter.createWatermeter("/home/stipo/Dev/java-lab-2020-StipoMargic/Lab3/src/main/java/Lab3/jsonFile/config.json");
        watermeter.publish();
    }
}