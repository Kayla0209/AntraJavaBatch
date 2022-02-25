package Day3;

public class StaticKeyword {
    static int a = 1; // initialize by JVM at the beginning
    static int b; // lazy loading

    static { // static block, used to initialize some fields
        System.out.println("inside static block.");
        b = a + 1;
    }

    public static void main(String[] args) {
/*        System.out.println("from main.");
        System.out.println("a = " + a);
        System.out.println("b = " + b);*/

        Student one = new Student(1, "A");
        Student two = new Student(2, "b");
        System.out.println(Student.getCollege()); // here we did not initialize the field, default value is null

        Student.college = "ABC"; // static filed belongs to the class, but not nay object
        System.out.println(Student.getCollege()); // we initialize the college


        //method2(); // we can access nonstatic in static method
        method3(); // we can access static class in static method
        StaticKeyword.method3(); // second way to call static method
    }

    public void method2() {} // nonstatic method

    public static void method3() {}

    public void method4() {
        method3(); // nonstatic method can access static method
        StaticKeyword.method3();

        method2();
    }

    static class StaticNestedClass { // we can use static on inner class, we cannot use static keyword on top level class
        // if you want to access static inner class, you don't need a reference
        // ex: Map class, can access Entry
    }

    class InnerClass { // if you want to access inner class, you have to create a reference to access it

    }

}


class Student {
    int id;
    String name;
    static String college; // store in

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String getCollege() {
        return college;
    }
}
