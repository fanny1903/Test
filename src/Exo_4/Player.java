package Exo_4;

public class Player {
    private int lives = 2;
    private int pos;
    private Game g;

    public Player(int pos, Game g){
        this.pos = pos;
        this.g = g;
    }
    public int getPos(){
        return pos;
    }
    public void hurt(){
        lives -= 1;
        if (lives <= 0){
            die();
        }
    }
    private void die(){
        System.out.println("player meurt");
        g.removePlayer(this);
    }
}
