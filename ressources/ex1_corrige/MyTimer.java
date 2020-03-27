package ex1_corrige;

public class MyTimer implements Runnable {
  String string;
  int waitTime;
  Thread thread;
  
  public MyTimer(String string, int waitTime){
    this.string = string;
    this.waitTime = waitTime;
    this.thread = new Thread(this);
    thread.start();
  }
  
  public void run() {
    try{
      while(true){
        System.out.println(string);
        Thread.sleep(waitTime);
      }
    } catch (Exception e) {};
  }

  public static void main(String[] args) {
    MyTimer first = new MyTimer("first",2000);
    MyTimer second = new MyTimer("second",3000);
  }
}
