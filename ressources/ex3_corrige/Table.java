package ex3_corrige;

public class Table{
    private  Object key = new Object();


    void printTable(int n){
        synchronized(key) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}

