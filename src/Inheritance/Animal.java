package Inheritance;

class Species{
    void fly()
    {
        System.out.println("flying");
    }
}








public class Animal {

    void eat(){
        System.out.println("Animal is eating");
    }
    void sound(){
        System.out.println("Animal is sounding");
    }


    public void fly() {
    }
}

class Dog extends Animal{
    @Override
    void sound() {
        System.out.println("Dog is barking");
    }
}
