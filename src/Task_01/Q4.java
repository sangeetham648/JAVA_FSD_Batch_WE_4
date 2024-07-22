package Task_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q4 {
    public static void main(String arg[]){
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 numbers : ");
        try {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if (a > b && c > b) {
                System.out.println("B is smaller");
            } else if (b > a && c > a) {
                System.out.println("A is smaller");
            } else {
                System.out.println("C is smaller");
            }
        }catch (InputMismatchException e ){
            System.out.println("Given value is unmatched format");
        }
    }
}

//Output:

//Enter 3 numbers :
//        10
//        44
//        6
//C is smaller

//Enter 3 numbers :
//        1
//        3
//        5
//A is smaller

//Enter 3 numbers :
//        12
//        4
//        66
//B is smaller