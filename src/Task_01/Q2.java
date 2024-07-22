package Task_01;
import java.util.*;
public class Q2 {
    public static void main(String arg[]){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");

        try{
            n= sc.nextInt();
            if(n>0){
                System.out.println("Positive number");
            } else if (n<0) {
                System.out.println("Negative number");
            } else{
                System.out.println("Given value is Zero");
            }
        }catch (InputMismatchException e ){
                System.out.println("Given value is unmatched format");
        }

    }
}


//Output:

//Enter number : 1
//Positive number

//Enter number : -5
//Negative number

//Enter number : 0
//Given value is Zero

//Enter number : a
//Given value is in unmatched format