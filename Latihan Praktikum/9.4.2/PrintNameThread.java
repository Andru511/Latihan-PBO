class PrintNameThread extends Thread {
    PrintNameThread(String name) {
       super(name);
       start();
    }
 
    public void run() {
       String name = getName();
       for (int i = 0; i < 100; i++) {
          System.out.print(name);
       }
    }
 }
 
 class TestThread {
    public static void main(String args[]) {
       new PrintNameThread("A");
       new PrintNameThread("B");
       new PrintNameThread("C");
       new PrintNameThread("D");
    }
 }