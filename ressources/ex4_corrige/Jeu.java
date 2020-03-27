package ex4_corrige;

import java.util.ArrayList;
public class Jeu {
    private ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    public Jeu(){
        this.bombs.add(new Bomb(2000, this));
        this.bombs.add(new Bomb(4000, this));
        this.bombs.add(new Bomb(1000, this));
    }

    public void detonation(Bomb bomb){
        System.out.println(bombs.size());
        System.out.println("ex4_corrige.Jeu : a bomb exploded");
        this.bombs.remove(bomb);
        System.out.println(bombs.size());
    }
}

