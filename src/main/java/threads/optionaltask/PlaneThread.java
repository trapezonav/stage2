package threads.optionaltask;

import java.util.concurrent.TimeUnit;

public class PlaneThread extends Thread{

    private Runway[] runways;

    public void setRunways(Runway[] runways) {
        this.runways = runways;
    }

    @Override
    public void run() {
        boolean flagOfEnd;
        flagOfEnd = false;
        while (!flagOfEnd) {
            for (Runway runway : runways) {
                if (runway.lock.tryLock()) {
                    runway.startInfo();
                    System.out.println(getName() + " начал выход на полосу");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + " взлетел");
                    runway.endInfo();
                    runway.condition.signalAll();
                    runway.lock.unlock();
                    flagOfEnd = true;
                    break;
                }
            }
        }
    }
}
