package Task_05;

//Q1. Write a program using map() method, to convert a list of Strings into uppercase.If the given List is: Stream names = Stream.of("aBc", "d", "ef");

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UppercaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> Lstrings = new ArrayList<>();

        System.out.println("Enter strings (type 'exit' to stop):");

        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            Lstrings.add(input);
        }

        List<String> uppercaseStrings = Lstrings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Uppercase Strings: " + uppercaseStrings);

        sc.close();
    }
}


//INPUT  :
//Enter strings (type 'exit' to stop):
//  aBc
//  d
//  ef
//  exit

//OUTPUT  :
//Uppercase Strings: [ABC, D, EF]