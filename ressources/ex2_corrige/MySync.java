package ex2_corrige;

public class MySync implements Runnable{
    public static int counter;


    @Override
    public void run(){
        int temp = counter;
        temp = temp + 1;
        counter = temp;
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new MySync());
        Thread t2 = new Thread(new MySync());
        t1.start();
        t2.start();
        // t1.join();       // le thread principal attend ici que t1 finisse
        // t2.join();       // le thread principal attend ici que t2 finisse
        System.out.println("Counter = " + String.valueOf(counter));
    }
}
