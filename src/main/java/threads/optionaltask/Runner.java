package threads.optionaltask;

import java.util.concurrent.ArrayBlockingQueue;

public class Runner {
    public static void main(String[] args) {
        int runwaysCount = 5;
        ArrayBlockingQueue<Runway> runways = new ArrayBlockingQueue<>(runwaysCount);
        for (int i = 0; i < runwaysCount; i++) {
            runways.add(new Runway("Полоса " + (i + 1)));
        }

        for (int i = 0; i < 10; i++) {
            PlaneThread plane = new PlaneThread();
            plane.setRunways(runways);
            plane.setName("Самолет " + (i + 1));
            plane.start();
        }
    }
}


