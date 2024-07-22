package Task_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q3 {
    public static void main(String arg[]){
        int n,rev=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        try {
            n = sc.nextInt();
            if(n>0) {
                while (n > 0) {
                    rev = rev * 10 + (n % 10);
                    n = n / 10;
                }
                System.out.println("Reverse of given number is " + rev);
            }else {
                n=-1*n;
                while (n > 0) {
                    rev = rev * 10 + (n % 10);
                    n = n / 10;
                }
                System.out.println("Reverse of given number is -" + rev);
            }
        }catch (InputMismatchException e ){
            System.out.println("Given value is unmatched format");
        }
    }

}

//output:
//Enter number : 456
//Reverse of given number is 654

//Enter number : -584
//Reverse of given number is -485