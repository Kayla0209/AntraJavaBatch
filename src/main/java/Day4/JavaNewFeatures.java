package Day4;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class JavaNewFeatures {
    public static void main(String[] args) {
        Drawable d = () -> {
            System.out.println("hello, drawing a circle");
        };
        d.draw();

        Draw d2 = new Draw();
        d2.draw();

        Queue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> e2-e1);
        Queue<Integer> maxHeap2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        Supplier<Double> generateRandomNumber = () -> Math.random();
        System.out.println(generateRandomNumber.get());

        // Optional
        String str = null;
        if (str == null) {
            System.out.println("nothing here");
        } else {
            System.out.println(str);
        }

        // same as above
        Optional<String> opt = Optional.ofNullable(str);
        System.out.println(opt.orElse("nothing here"));

        // Stream API
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        System.out.println(list.stream().filter(e -> e > 3).collect(Collectors.toList()));
    }
}

@FunctionalInterface // this is optional
interface SayBye {
    void sayBye(); // only one abstract method -> functional interface
    // can have many concrete functions
    default public void sayHello() {
        System.out.println("Hello");
    }
    default public void sayGB() {
        System.out.println("Good Bye");
    }
}

interface Drawable {
    public void draw();
}

class Draw implements Drawable {
    @Override
    public void draw() {
        System.out.println("hello, drawing a circle 2");
    }
}