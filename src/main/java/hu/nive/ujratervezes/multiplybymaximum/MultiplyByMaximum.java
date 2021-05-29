package hu.nive.ujratervezes.multiplybymaximum;

import java.util.Arrays;

public class MultiplyByMaximum {
    public int[] multiplyByMaximum(int[] numbers, int n) {
        if (numbers == null || n < 1) {
            throw new IllegalArgumentException("Wrong input!");
        }
        int[] result = new int[numbers.length];
        if (numbers.length != 0) {
            int max = Arrays.stream(numbers).max().orElseThrow();
            for (int i = 0; i < numbers.length; i++) {
                if ((i + 1) % n == 0) {
                    result[i] = numbers[i] * max;
                } else {
                    result[i] = numbers[i];
                }
            }
        }
        return result;
    }
}
