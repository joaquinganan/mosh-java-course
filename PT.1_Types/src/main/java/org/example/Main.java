package org.example;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {
        byte myAge = 30;
        long viewsCount = 3_123_456_789L; //compiler assumes this is an integer unless we specify 'L' at the end
        float price = 10.99F; //same her. Need to specify the data type initial
        char letter = 'A';
        boolean isEligible = false;

        Date now = new Date();
        // for reference types we should always allocate the memory with the word 'new'
        //Date is an instance of the date class. It defines a new templates or blueprints to create objects, new instances.
        //An object is an instance of a class
        System.out.println(now);

        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2);

        String message = "  Hello \"World\"" + "!!  ";
        System.out.println(message.trim());
        System.out.println(message);

        //parameters are the holes we define in our methods
        //arguments are the actual values we pass in our methods

        int[] numbers = {2, 3, 5, 1, 4};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        int [][] dimNumbers = { {1,2,3}, {4, 5, 6}}; //2 rows & 3 column
        System.out.println(Arrays.deepToString((dimNumbers)));

        final float PI = 3.14F; // final declares a constant. By convention, constants are expressed with capital letters.

        //expression is a piece of code that produces a value.
        double result = (double)10 / (double)3;
        int x = 1;
        int y = x++;
        //as x is being incremented post the assignation, y will remain as 1.
        System.out.println(x);
        System.out.println(y);
        int w = 1;
        w += 2; //augmented assignment
        System.out.println(w);

        //implicit casting
        // byte > short > int > long > float > double
        double x3 = 1.1;
        int y3 = (int)x3 + 2; //explicit casting
        System.out.println(y3);

        String output = NumberFormat.getPercentInstance().format(0.1);
        System.out.println(output);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.println("You are " + name);

        /* Mortgage Calculator */

        byte MONTHS_IN_YEAR = 12;
        byte PERCENT = 100;
        Scanner mortgageScanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = mortgageScanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = mortgageScanner.nextFloat();
        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = mortgageScanner.nextByte();

        int numberOfPayments = years * MONTHS_IN_YEAR;
        double mortgage = principal
                * ( (monthlyInterestRate * (Math.pow(++monthlyInterestRate,numberOfPayments)))
                / (Math.pow(monthlyInterestRate,numberOfPayments) - 1)); //mortgageInterestRate previously increased by 1

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);

    }
}