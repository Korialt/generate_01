package com.dent.acm;

import java.util.Scanner;

public class MainTemplate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
        }

        int sum = 0;
        for (int num : arr){
            sum += num;
        }
        System.out.println("Sum: ", sum);
        //is diffe?
    }
    sc.close();
}