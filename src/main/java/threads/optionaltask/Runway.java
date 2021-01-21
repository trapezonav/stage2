package threads.optionaltask;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Runway {
    private String name;
    private boolean isFree = true;

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public Runway(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isFree() {
        return isFree;
    }

    public void startInfo() {
        isFree = false;
        System.out.println(name + " \"приняла\" " + Thread.currentThread().getName());
    }

    public void endInfo(){
        System.out.println(name + " освободилась");
        isFree = true;
    }
}
