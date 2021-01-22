package threads.optionaltask;

import java.util.concurrent.ArrayBlockingQueue;

public class Runner {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runway> runways = new ArrayBlockingQueue<>(5);
        int runwaysCapacity = runways.remainingCapacity();
        for (int i = 0; i < runwaysCapacity; i++) {
           runways.add(new Runway("Полоса " + (i+1)));
        }

        for (int i = 0; i < 10; i++) {
            PlaneThread plane = new PlaneThread();
            plane.setRunways(runways);
            plane.setName("Самолет " + (i+1));
            plane.start();
        }
    }
}


