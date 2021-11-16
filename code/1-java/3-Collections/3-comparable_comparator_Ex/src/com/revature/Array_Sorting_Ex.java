package com.revature;

public class Array_Sorting_Ex {
    public static void main(String[] args) {
        int[] numbers = {5, 4, 1, 2};
        sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

    }

    private static void sort(int[] numbers) {
        // sorting algorithm
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }


}
