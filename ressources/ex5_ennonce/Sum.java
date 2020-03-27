package ex5_ennonce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sum {

    public static void main(String[] args) throws IOException {
        String filename = "src/numbers.txt";
        BufferedReader file = new BufferedReader(new FileReader(filename));
        String line;
        double sum = 0;
        while ((line = file.readLine()) != null) {
            for (String s: line.split(" ")){
                sum += Double.valueOf(s);
            }
        }
        System.out.println(sum);
        file.close();
    }
}
