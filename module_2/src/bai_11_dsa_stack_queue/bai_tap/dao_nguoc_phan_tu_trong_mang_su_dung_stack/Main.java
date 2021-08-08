package bai_11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_trong_mang_su_dung_stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
//        int[] originalArray = new int[size];
//
//        for (int i = 0; i < size; i++) {
//            System.out.print("array[" + i + "] = ");
//            originalArray[i] = sc.nextInt();
//        }

        String[] originalArrayString = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            originalArrayString[i] = sc.next();
            sc.nextLine();
        }

        System.out.println("Original Array is:");
        ReverseArrayUsingStack.showArray(originalArrayString);

        Stack<Integer> stack = new Stack<>();

        Stack<String> stringStack = new Stack<>();

        ReverseArrayUsingStack.pushIntoStack(originalArrayString, stringStack);
        ReverseArrayUsingStack.reverseArray(originalArrayString, stringStack);

        System.out.println("\nReversed Array is:");
        ReverseArrayUsingStack.showArray(originalArrayString);
    }
}
