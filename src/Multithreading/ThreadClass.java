package Multithreading;

class MyThrea extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class ThreadClass {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        Thread t =Thread.currentThread();
        t.setName("MyThread");
        System.out.println(Thread.currentThread().getName());


        MyThread t1=new MyThread();
        t1.start();
    }
}
