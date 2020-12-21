import Classes.Watermeter;

import java.io.IOException;

public class    App {

    public static void main(String args[]) throws IOException, InterruptedException {
        Watermeter watermeter = Watermeter.createWatermeter("/home/stipo/Dev/java-lab-2020-StipoMargic/Lab5/src/main/java/config/config.json");
        watermeter.publish();
    }
}
