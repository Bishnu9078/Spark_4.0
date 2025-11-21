public class Course {

    String name;
    int duration;

    // Default Constructor
    Course() {
        System.out.println("Default Constructor called");
        this.name = "Not Assigned";
        this.duration = 0;
    }

    // Parameterized Constructor
    Course(String name, int duration) {
        this.name = name;
        this.duration = duration;
        System.out.println("Parameterized Constructor called for: " + name);
    }

    void learn() {
        System.out.println("Course Name: " + name);
        System.out.println("Duration: " + duration + " months");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {

        // Calling Default Constructor
        Course c1 = new Course();
        c1.learn();

        // Calling Parameterized Constructor
        Course c2 = new Course("Java", 4);
        c2.learn();

        Course c3 = new Course("Devops", 5);
        c3.learn();

        Course c4 = new Course("DSA", 3);
        c4.learn();
    }
}
