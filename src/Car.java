public class Car {

    String color;

    String brand;

    int speed;  //instance variable


    public static void main(String[] args) {
        Car car1 = new Car();

        car1.speed=100;
        car1.run();
    }

    public void run() {
        System.out.println("Car is running at " + speed);
    }
}
