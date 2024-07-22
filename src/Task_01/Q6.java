package Task_01;

import java.util.Scanner;

public class Q6 {
    public static void main(String arg[]){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    System.out.print(n - j + "j ");
                } else {
                    System.out.print(n - i + "i ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
