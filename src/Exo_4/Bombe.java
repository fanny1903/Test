package Exo_4;

public class Bombe implements Runnable {
    private int time_before_explosion;
    private Thread t;
    private Game g;
    private int pos;

    public Bombe(int time,int pos, Game g) {
        time_before_explosion = time;
        this.g = g;
        this.pos = pos;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time_before_explosion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g.notifyExplosion(this);
    }
    public int getPos(){
        return pos;
    }
}
