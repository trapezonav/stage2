package threads.maintask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Parking {
    public static void main(String[] args) {
        ArrayBlockingQueue<Object> parkingSpaces = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 100; i++) {
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