package Exo_1;

public class MyTimer implements Runnable {
    String string;
    int waitTime;

    public MyTimer(String string, int waitTime) {
        this.string = string;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.print(string);
                Thread.sleep(waitTime);
            }
        } catch (Exception e) { } ;
//se met en attente
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTimer("A", 100));
        Thread t2 = new Thread(new MyTimer("B", 70));
        Thread t3 = new Thread(new MyTimer("C", 65));
        t1.start();
        t2.start();
        t3.start();
    }
}