package ex5_corrige;

public class lineSum implements Runnable{
    private String line;
    private double line_tot;

    public lineSum(String s){
        line = s;
    }

    @Override
    public void run() {
        for (String s : line.split(" ")) {
            line_tot += Double.valueOf(s);
        }
        SumParallel.updateTot(line_tot);
    }
}
