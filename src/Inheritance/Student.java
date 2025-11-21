package Inheritance;

public class Student {

    String name;

    int age;

    String course;

    Student()
    {
        this("Unknown", 0);
    }

    Student(String name, int age)
    {
        this.name=name;
        this.age=age;
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.studentDetails();


        Student s2 = new Student("Ayush", 12);
        s2.studentDetails();
        s1.studentDetails();
        s2.hello(s2);
    }

    void studentDetails(){
        System.out.println("name "+name+ " age "+age);
        hello(this); // this will repeat here as default constructor
    }


    void hello(Student s){
        System.out.println("hello "+ s.name);
    }
}
