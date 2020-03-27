package Exo_4;

import java.util.ArrayList;

public class Game {
    private ArrayList<Bombe> bombes = new ArrayList<Bombe>();
    private ArrayList<Player> players = new ArrayList<Player>();

    public Game() {
        players.add(new Player(4, this));
        bombes.add(new Bombe(300, 3, this));
        bombes.add(new Bombe(2000, 5, this));
        bombes.add(new Bombe(4000, 0, this));
    }

    public void notifyExplosion(Bombe bombe) {
        bombes.remove(bombe);
        System.out.println("Bombe a explosé, il reste " + bombes.size() + " bombes");

        for (int i = 0; i < players.size(); ) {
            Player p = players.get(i);
            if (Math.abs(p.getPos() - bombe.getPos()) <= 2) {
                p.hurt();

            }
            if (i + 1 < players.size() && p == players.get(i)) {
                i += 1;
            }
        }
    }

        public void removePlayer (Player player){
            players.remove(player);
        }
    }
