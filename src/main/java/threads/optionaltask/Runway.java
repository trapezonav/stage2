package threads.optionaltask;

public class Runway {
    private String name;

    public Runway(String name) {
        this.name = name;
    }

    public void startInfo() {
        System.out.println(name + " \"приняла\" " + Thread.currentThread().getName());
    }

    public void endInfo() {
        System.out.println(name + " освободилась");
    }
}
