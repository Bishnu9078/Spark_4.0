package Multithreading;

class JointThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("child thread");
        }
    }
}

public class JointDemo {
    public static void main(String[] args) {
        try {
            JointThread t1 = new JointThread();
            t1.start();
            t1.join();  // wait for child thread to finish

            for (int i = 0; i < 5; i++) {
                System.out.println("main thread");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
