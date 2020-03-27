package ex4_corrige;

public class Bomb implements Runnable{
    private int countDown = 2000;
    private Jeu jeu;
    private Thread thread;

    public Bomb(int countDown, Jeu jeu){
        this.countDown = countDown;
        this.jeu = jeu;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public void run(){
        try {
            Thread.sleep(this.countDown);
            System.out.println("Detonation...");
            this.jeu.detonation(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

