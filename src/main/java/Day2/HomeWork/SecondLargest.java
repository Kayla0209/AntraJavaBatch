package Day2.HomeWork;

public class SecondLargest {
    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 3, 56};
        System.out.println(SecondLargestInt(a));
    }

    public static int SecondLargestInt(int[] array) {
        if (array == null || array.length < 2) {
            return Integer.MIN_VALUE;
        }

        // array is not null and there are at least two elements in array
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int index = 0;
        while (index < array.length) {
            if (array[index] > max) { // cur number is the largest so far
                secondMax = max;
                max = array[index];
            } else if (array[index] > secondMax) { // cur number is <= max and > secondMax
                secondMax = array[index];
            }
            index++;
        }

        return secondMax;
    }
}
