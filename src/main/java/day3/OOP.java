package day3;

public class OOP {
}

class POL {
    public void method1() throws Exception {
        try {
            throw new Exception();
        } catch (Exception ex) {
            //rollback()
            //shutdown
        }
    }
}

class IKH extends POL {
    // override
    @Override
    public void method1() {

    }

    //overloading
    public void method1(int i) {

    }
}

// customize exception
class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String msg) {
        System.out.println(msg);
    }
}
