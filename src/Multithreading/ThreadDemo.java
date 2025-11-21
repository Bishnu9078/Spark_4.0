package Multithreading;

class MyThread extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++){
            System.out.println("child Thread");
        }
    }
}

public class ThreadDemo {

    public static void main(String[] args) {
        MyThread t= new MyThread();
        t.start();
        //t.run() no multithreading
        for (int i = 0; i < 5; i++) {
            System.out.println("main");
        }
    }
}
