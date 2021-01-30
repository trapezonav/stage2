package threads.maintask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Parking {
    public static void main(String[] args) {
        int numberOfParkingSpaces = 10;
        int numberOfCars = 100;
        ArrayBlockingQueue<Object> parkingSpaces = new ArrayBlockingQueue<>(numberOfParkingSpaces);
        for (int i = 0; i < numberOfCars; i++) {
            new Thread(() -> {
                Object car = new Object();
                boolean resultOfAdding;
                try {
                    resultOfAdding = parkingSpaces.offer(car, 100, TimeUnit.MILLISECONDS);
                    if (resultOfAdding) {
                        TimeUnit.MILLISECONDS.sleep(50);
                        parkingSpaces.remove(car);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " I'm sad and I'm leaving");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}