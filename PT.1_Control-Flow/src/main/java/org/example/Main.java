package org.example;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    static void practice_ComparisonOperators() {
        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
        System.out.println(isEligible);
    }

    static void practice_IfStatements() {
        int temp = 32;
        if (temp > 30) {
            System.out.println("It's a hot day");
            System.out.println("Drink water");
        } else if (temp > 20)
            System.out.println("Beautiful day");
        else
            System.out.println("Cold day");

        // Simplifying If Statements
        int income = 120_000;
        boolean hasHighIncome = (income > 100_000);

        // Ternary Operations
        String className = income > 100_000 ? "First" : "Economy";
    }

    static void practice_SwitchStatements() {
        String role = "admin";

        switch (role) {
            case "admin":
                System.out.println("You're an admin");
                break;

            case "moderator":
                System.out.println("You're a moderator");
                break;

            default:
                System.out.println("You're a guest");
        }
    }

    static void exercise_FizzBuz() {
        /**
         * Criteria:
         * if the number is divisible by 5 print "Fizz"
         * if the number is divisible by 3 print "Buzz"
         * if the number is divisible by both 5 and 3 print "FizzBuzz"
         * the number is not divisible by both 5 or 3 print the number itself
         */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please provide the number: ");
        int number = scanner.nextInt();

        if ((number % 3 == 0) && (number % 5 == 0))
            System.out.println("FizzBuzz");
        else if (number % 5 == 0)
            System.out.println("Fizz");
        else if (number % 3 == 0)
            System.out.println("Buzz");
        else
            System.out.println(number);
    }

    static void practice_ForLoops() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World " + i);
        }
    }

    static void practice_WhileLoops() {
        // These are better when we don't know the specific amount of times we want to iterate
        int i = 0;
        while (i > 0) {
            System.out.println("Hello World " + i);
            i--;
        }

        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("quit")) {
            System.out.println("Input: ");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        }
    }

    static void practice_DoWhileLoops() {
        // This one gets executed at least once
        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            System.out.println("Input: ");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        } while (!input.equals("quit"));
    }

    static void practice_BreakAndContinue() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass"))
                continue;
            if (input.equals("quit"))
                break;
            System.out.println(input);
        }
    }

    static void practice_ForEachLoops() {
        // To iterate over Arrays or Collections
        String[] fruits = { "Apple", "Mango", "Orange" };

        for (int i = fruits.length - 1; i >= 0; i--)
            System.out.println(fruits[i]);

        // For each always goes forward
        // Doesn't have access to the index of the items
        for (String fruit : fruits)
            System.out.println(fruit);
    }

    static void exercise_MortgageCalculator() {

        /* Mortgage Calculator */

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        int principal_bottomLimit = 1_000;
        int principal_topLimit = 1_000_000;

        float annualInterestRate = 0.0f;
        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;

        byte years = 0;
        int numberOfPayments = 0;
        Scanner mortgageScanner = new Scanner(System.in);

        //Enter a number between 1,000 and 1,000,000.
        while(true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = mortgageScanner.nextInt();
            if (principal >= principal_bottomLimit && principal <= principal_topLimit)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        //Enter a value greater than 0 and less than or equal to 30.
        while(true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = mortgageScanner.nextFloat();
            if(annualInterestRate > 0 && annualInterestRate <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }

        //Enter a value between 1 and 30
        while(true) {
            System.out.print("Period (Years): ");
            years = mortgageScanner.nextByte();
            if(years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        double mortgage = principal
                * ((monthlyInterestRate * (Math.pow(++monthlyInterestRate, numberOfPayments)))
                / (Math.pow(monthlyInterestRate, numberOfPayments) - 1)); //mortgageInterestRate previously increased by 1

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static void main() {
        practice_ComparisonOperators();
        practice_IfStatements();
        practice_SwitchStatements();
        exercise_FizzBuz();
        practice_ForLoops();
        practice_WhileLoops();
        practice_DoWhileLoops();
        practice_BreakAndContinue();
        practice_ForEachLoops();
        exercise_MortgageCalculator();
    }

}