package Task_01;

import java.util.Scanner;

public class Q5 {
    public static void main(String arg[]){
        double purchase_amt,total_amt;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Purchase Amount : ");
        purchase_amt= sc.nextDouble();
        if(purchase_amt > 499 && purchase_amt<1001){
            total_amt = purchase_amt - (purchase_amt * 0.1);
        } else if (purchase_amt > 1000) {
            total_amt = purchase_amt - (purchase_amt * 0.2);
        }else {
            total_amt = purchase_amt;
        }
        System.out.println("Total Payable Amount is "+ total_amt);
    }
}

//Output:
//Enter Purchase Amount : 200
//Total Payable Amount is 200.0

//Enter Purchase Amount : 502.3
//Total Payable Amount is 452.07

//Enter Purchase Amount : 1560.35
//Total Payable Amount is 1248.28
