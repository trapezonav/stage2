package threads.optionaltask;

public class Runner {
    public static void main(String[] args) {
        Runway[] runways = new Runway[5];
        for (int i = 0; i < runways.length; i++) {
           runways[i] = new Runway( "Полоса №" + i);
        }

        for (int i = 0; i < 10; i++) {
            PlaneThread plane = new PlaneThread();
            plane.setRunways(runways);
            plane.setName("plane " + i);
            plane.start();
        }
    }
}


