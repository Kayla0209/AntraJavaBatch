package day3.homework;

/*
Check all the keywords below:
 - for data types: byte, short, int, long, float, double, char, boolean
 - flow control: if, else, switch, case, default, for, do, while, break, continue, return
 - modifiers: public, private, protected, static, final, abstract, synchronized, native, strictfp, transient, volatile
 - exception handling: try, catch, finally, throw, throws, assert
 - class related: class, package, import, extends, implements, interface
 - Object related keywords: new, instanceof, super, this
*/

public class Keywords {
    public static void main(String[] args) {
        ExceptionHandling e = new ExceptionHandling(18);
        e.assertKeyword();

    }
}

// - for data types: byte, short, int, long, float, double, char, boolean
class DataTypes {
    // designates the 8 bits signed integer primitive type, the range is [-128, 127].
    static byte byte1 = 65;
    static byte byte2 = 'A'; // print 65

    // stores whole numbers from -32768 to 32767. (-2^15 to 2^15-1)
    static short short1 = 32456;

    // stores whole numbers from -2147483648 to 2147483647. (-2^31 to 2^31-1)
    static int int1 = 2123456789;

    // stores whole numbers from -9223372036854775808 to 9223372036854775808. (-2^63 to 2^63-1)
    static long long1 = 13451345;

    // stores fractional numbers from 3.4e-038 to 3.4e^038.
    // float value should end with an 'f' or 'F'
    static float float1 = 2.3f;
    static float float2 = 24.564F;

    // stores fractional numbers from 1.7e−308 to 1.7e+308.
    // double value can end with a 'd' or 'D', but doesn't have to
    static double double1 = 3.4624562;
    static double double2 = 5.42362d;
    static double double3 = 3.4624562345D;

    // stores a single character
    static char char1 = 'e';
    static char char2 = '/';
    static char char3 = '1';

    // only takes values true or false
    static boolean boolean1 = true;
    static boolean boolean2 = false;
}

// - flow control: if, else, switch, case, default, for, do, while, break, continue, return
class FlowControl {
    // Default methods enable new functionality to be added to the interfaces of libraries and ensure binary
    // compatibility with code written for older versions of those interfaces.
    int age;

    public FlowControl(int age) {
        this.age = age;
    }

    public void ifElseKeyWord() {
        // if specifies a block of Java code to be executed if a condition is true
        // else specifies a block to be executed if the same condition is false
        // else if specifies a new condition to test, if the first condition is false
        // we can use if without else, but we cannot use else if or else without if
        if (age >= 18) {
            System.out.println("The age is larger than or equal to 18.");
        } else if (age >= 0) {
            System.out.println("The age is less than 18, and larger than or equal to 0.");
        } else {
            System.out.println("The age is less than 0. Wrong!");
        }
    }

    public void switchCaseDefaultBreakKeyword() {
        // switch selects one of many code clocks to be executed
        // we compare the value of expression with the values of each case,
        // if there is a match, the associated block of code is executed.
        // break is always used here to break out of the switch block when we find a match
        // default is the default block in a switch statement (first definition of default)
        switch (age) {
            case 0:
                System.out.println("Just born!");
                break;
            case 6:
                System.out.println("Go to primary school.");
                break;
            case 12:
                System.out.println("Go to middle school.");
                break;
            case 15:
                System.out.println("Go to high school.");
                break;
            case 18:
                System.out.println("Go to college.");
                break;
            default:
                System.out.println("Nothing special.");
        }
    }

    public void forBreakContinueKeyword() {
        // for loops a block of code a number of times
        // for (statement_1; statement_2; statement_3) {}
        // statement_1 sets a variable before the loop starts
        // statement_2 defines the condition for the loo to run. If true, go on; if false, end loop.
        // statement_2 increases(or decreases) a value each time the code block in the loop has been executed
        // break will break out of the for block
        // continue will end the current iteration in for loop, and continue to the next iteration
        for (int i = 0; i <= age; i++) {
            if (i >= 21) {
                System.out.println("You can drink alcohol now!");
                break;
            }
            if (i == 20) {
                System.out.println("Almost there!");
                continue;
            }
            System.out.println("You are only " + i + " year(s) old. No alcohol.");
        }
    }

    public void doWhileBreakContinueKeyword() {
        // do is used together with while to create a do-while loop
        // while loops through a clock of code as long as a specified condition is true
        // do-while loop will at least be executed once, since it checks condition at the end of each iteration
        // while loop checks condition at the beginning of each iteration, so the code block may not be executed
        // break will break out of the while/do-while loop
        // continue will end the current iteration in while/do-while loop, and continue to the next iteration
        int annaAge = 6;
        do {
            if (age < 0) {
                System.out.println("Not a valid age.");
                break;
            }
            if (annaAge > age) {
                System.out.println("Anna is " + annaAge + ", older than you. Bye.");
                break;
            }
            if (annaAge == age) {
                System.out.println("Anna is the same age as you.");
                annaAge++;
                continue;
            }
            System.out.println("Anna is " + annaAge + ", younger than you");
            annaAge++;
        } while (annaAge <= age);

        int benAge = 4;
        while (benAge <= age) {
            if (age < 0) {
                System.out.println("Not a valid age.");
                break;
            }
            if (benAge == age) {
                System.out.println("Ben is the same age as you.");
                benAge++;
                continue;
            }
            System.out.println("ben is " + benAge + " younger than you");
            benAge++;
        }
    }

    public int xreturnKeyword() {
        // return finished the execution of a method, and can be used to return a value from a method.
        return age + 5;
    }
}

// - modifiers: public, private, protected, static, final, abstract,
//              synchronized, native, strictfp, transient, volatile
class Modifiers { // if add public before class, the class becomes a public class. Only one public class in one java file.
    // 1. public
    //  - can be used for classes, attributes, methods, and constructors.
    //  - It will make them accessible by any other class.
    // 2. private
    //  - can be used for attributes, methods, and constructors.
    //  - It will make them only accessible within the declared class.
    // 3. protected
    //  - can be used for attributes, methods and constructors.
    //  - It will make them accessible in the same package and subclasses.
    // 4. static
    //  - used for methods and attributes.
    //  - It will make them can be accessed without creating an object of a class.
    //  - Also can be used to create static nested class, which can only access the static
    //    members of its outer class
    // 5. final
    //  - used for classes, attributes, and methods.
    //  - It will make them un-changeable (impossible to inherit or override).
    // 6. abstract
    //  - used for classes and methods.
    //  - It will make them can be accessed without creating an object of a class.
    // 7. synchronized
    //  - can be used for methods and statements. ex: synchronized{ CODE_HERE }
    //  - for a synchronized method, when one thread is executing it, all other threads that invoke it for the same
    //    object block until the first thread is done with the object.
    //  - Sometimes we don't need to synchronize the whole method. Then we can only synchronize a block of codes.
    //  - guarantees both mutual exclusion and visibility.
    // 8. native
    //  - can be used for methods
    //  - it indicates that a method is implemented in platform-dependent code, often seen in C.
    // 9. strictfp
    //  - by default, the floating-point computations in Java are platform-dependent.
    //  - can be used for classes, non=abstract-methods or interfaces.
    //  - it is used for restricting floating-point calculations and ensuring the same result on every platform while
    //    performing operations in the floating-point variable.
    // 10. transient
    //  - is used to avoid serialization. Serialization is the process of converting an object into a byte stream.
    //  - this way, we can protect some sensitive data such as ssn.
    // 11. volatile
    //  - ensures the visibility aspect of the data change without providing mutual exclusion.

    // Something useful
    // Mutual Exclusion – only one thread executes a critical section at a time
    // Visibility – changes made by one thread to the shared data are visible to other threads to maintain data consistency

    public int age; // public - accessible to any other class
    public static final String college = "UCLA"; // final - cannot be modified, static - can be accessed without an instance

}

// - exception handling: try, catch, finally, throw, throws, assert
class ExceptionHandling {
    int age;

    public ExceptionHandling(int age) {
        this.age = age;
    }

    public void tryCatchFinallyKeyword() {
        // try allows you to define a block of code to be tested for errors while it is being executed.
        // catch allows you to define a block of code to be executed, if an error occurs in the try block.
        try {
            int[] num = {1, 2, 3};
            System.out.println(num[20]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bound.");
        } finally {
            System.out.println("Here is finally.");
        }
    }

    public void throwKeyword() throws ArithmeticException {
        // throws is used to indicate what exception type may be thrown by a method
        // can declare multiple exceptions
        // is followed by a class

        // throw is used fo throw an exception for a method, used together with exception type.
        // is followed by an object (new type)
        if (age < 18) {
            throw new ArithmeticException("Access denied. At least 18 years old.");
        }
    }

    public void assertKeyword() {
        // assert is used to declare an expected boolean condition in a program.
        // If the program is running with assertions enabled, then the condition is checked at runtime.
        // If the condition is false, the Java runtime system throws an AssertionError.
        // *** should enable assertion manually -ea
        assert (age < 18) : "Too young!";
        System.out.println("age is " + age);
    }
}

// - class related: class, package, import, extends, implements, interface
class classRelated {
    // class is used to create a class.
    // package is used to create a package.
    // import is used to import a package, class or interface.
    // extends is used to extend a class.
    // implements is used to implement an interface.
    // interface is used to declare an interface, which is a special type of class that only contains abstract methods.
}

// - Object related keywords: new, instanceof, super, this
class objectRelatedKeyword {
    // new is used to create= new objects;
    // instanceof checks whether an object is an instance of a specific class or an interface.
    // ex: Student myObj = new Student();
    //     System.out.println(myObj instanceof Student); -> return true
    // super is used to call superclass methods, and to access the superclass constructor.
    // this refers to the current object in a method or constructor.
}