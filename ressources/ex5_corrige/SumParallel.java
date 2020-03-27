package ex5_corrige;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SumParallel {
    private static double sum = 0;

    public static synchronized void updateTot(double t){
        sum += t;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final long startTime = System.currentTimeMillis();
        String filename = "src/numbers.txt";
        BufferedReader file = new BufferedReader(new FileReader(filename));
        String line;
        ArrayList<Thread> threads = new ArrayList<Thread>();

        while ((line = file.readLine()) != null) {
            Thread t = new Thread(new lineSum(line));
            t.start();
            threads.add(t);
        }
        for(Thread t: threads){
            t.join();
        }

        System.out.println(sum);
        file.close();
    }
}
