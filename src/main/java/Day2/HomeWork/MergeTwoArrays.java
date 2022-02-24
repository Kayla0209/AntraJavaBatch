package Day2.HomeWork;

import java.util.Arrays;

public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{6,7,9,0};
        int[] res = merge(a,b);
        if (res != null) {
            for (int i = 0; i < res.length; i++) {
                System.out.println(res[i]);
            }
        } else {
            System.out.println("result is null");
        }
    }

    public static int[] merge(int[] a, int[] b) {
        if (a == null && b == null) { // both a and b are null
            return null;
        } else if (a == null) { // only a is null, b is not null
            return Arrays.copyOf(b, b.length);
        } else if (b == null) { // only b is null, a is not null
            return Arrays.copyOf(a, a.length);
        }

        // both a and b are not null
        if (a.length == 0 && b.length == 0) { // both a and b are empty
            return new int[0];
        } else if (a.length == 0) { // only a is empty
            return Arrays.copyOf(b, b.length);
        } else if (b.length == 0) { // only b is empty
            return Arrays.copyOf(a, a.length);
        }

        //both a and b are not empty
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int j = 0; j < b.length; j++) {
            result[a.length + j] = b[j];
        }
        return result;
    }
}
