package Multithreading;

class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getPriority());
    }
}
public class PriorityDemo {
    public static void main(String[] args) {
        MyThread2 t2=new MyThread2();
        t2.setName("Thread2");
        t2.setPriority(Thread.MIN_PRIORITY);

        MyThread t3=new MyThread();
        t3.setName("Thread3");
        t3.setPriority(Thread.MAX_PRIORITY);

        t2.start();
        t3.start();
    }
}
