package threads.optionaltask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PlaneThread extends Thread {

    private ArrayBlockingQueue<Runway> runways;

    public void setRunways(ArrayBlockingQueue<Runway> runways) {
        this.runways = runways;
    }

    @Override
    public void run() {
        Runway runwayTemp;
        try {
            runwayTemp = runways.take();
            runwayTemp.startInfo();
            System.out.println(getName() + " вышел на полосу");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(getName() + " взлетел");
            runwayTemp.endInfo();
            runways.put(runwayTemp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
