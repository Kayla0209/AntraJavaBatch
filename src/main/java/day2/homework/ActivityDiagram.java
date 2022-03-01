package day2.homework;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ActivityDiagram {
    public static void main(String[] args) {
        func();
    }

    public static void func() {
        while (true) {
            String input = getInput();
            if (input.equals("q")) {
                System.out.println("You quit.");
                return;
            } else if (isNegNumber(input)) {
                System.out.println("Your input is a negative number. Please input a positive number.");
            } else if (isPostiveNumber(input)) {
                soSomething(Double.parseDouble(input));
            } else {
                System.out.println("Please input a positive number.");
            }
        }
    }

    public static void soSomething(double d) {
        System.out.println("This is your input: " + d + ".");
    }

    public static String getInput() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter something: ");
        String input = myObj.nextLine();
        return input;
    }

    public static boolean isNegNumber(String s) {
        if (s == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("-\\d+(\\.\\d+)?");
        return pattern.matcher(s).matches();
    }

    public static boolean isPostiveNumber(String s) {
        if (s == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        return pattern.matcher(s).matches();
    }

}
