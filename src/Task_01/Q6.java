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
                    System.out.print(n - j + " ");
                } else {
                    System.out.print(n - i + " ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
//Output:
//Enter number : 5
//        5 5 5 5 5
//        5 4 4 4 4
//        5 4 3 3 3
//        5 4 3 2 2
//        5 4 3 2 1

//Enter number : 3
//        3 3 3
//        3 2 2
//        3 2 1

//Enter number : 10
//        10 10 10 10 10 10 10 10 10 10
//        10 9 9 9 9 9 9 9 9 9
//        10 9 8 8 8 8 8 8 8 8
//        10 9 8 7 7 7 7 7 7 7
//        10 9 8 7 6 6 6 6 6 6
//        10 9 8 7 6 5 5 5 5 5
//        10 9 8 7 6 5 4 4 4 4
//        10 9 8 7 6 5 4 3 3 3
//        10 9 8 7 6 5 4 3 2 2
//        10 9 8 7 6 5 4 3 2 1
