package bai_11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_trong_mang_su_dung_stack;

import java.util.Stack;

public class ReverseArrayUsingStack {

    public static void pushIntoStack(String[] array, Stack<String> stack) {
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
    }

    public static void reverseArray(String[] array, Stack<String> stack) {
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    public static void showArray(String[] array) {
        for (String e: array) {
            System.out.print(e + "\t");
        }
    }

    public static void pushIntoStack(int[] array, Stack<Integer> stack) {
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
    }

    public static void reverseArray(int[] array, Stack<Integer> stack) {
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    public static void showArray(int[] array) {
        for (int e: array) {
            System.out.print(e + "\t");
        }
    }
}
