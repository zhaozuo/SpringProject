package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] ch = new int[100100];
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            ch[i] = cin.nextInt();
        }
        Arrays.sort(ch, 0, n-1);
        int sum = 0;
        int[] ch2 = new int[100100];
        int mid = n / 2;
        int j = 0;
        for (int i = 0; i < n; ++i) {
            if(i % 2 == 0){
                ch2[i] = ch[mid];
                mid++;
            }else {
                ch2[i] = ch[j];
                j++;
            }
        }

        for (int i = 0; i < n-1; i++) {
            sum += Math.abs(ch2[i] - ch2[i+1]);
        }
        sum += Math.abs(ch2[n-1] - ch2[0]);
        System.out.println(sum);
        for (int i = 0; i < n; i++) {
            if (i == 0){
                System.out.print(ch2[i]);
            }
            else
                System.out.print(" "+ch2[i]);
        }
        cin.close();
    }
}
