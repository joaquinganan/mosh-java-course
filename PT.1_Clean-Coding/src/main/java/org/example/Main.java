package org.example;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    static void main () {
        exercise_MortgageCalculator();
    }
    public static void exercise_MortgageCalculator() {
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1_000, 1_000_000); //Enter a number between 1,000 and 1,000,000.
        float annualInterestRate = (float) readNumber("Annual Interest Rate: ", 1, 30); //Enter a value greater than 0 and less than or equal to 30.
        byte years = (byte) readNumber("Period (Years): ", 1, 30); //Enter a value between 1 and 30

        printMortgage(principal, annualInterestRate, years);
        printPaymentSchedule(years, principal, annualInterestRate);
    }

    private static void printMortgage(int principal, float annualInterestRate, byte years) {
        double mortgage = calculateMortgage(principal, annualInterestRate, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE\n--------\nMonthly Payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(byte years, int principal, float annualInterestRate) {
        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = getPaymentSchedule(principal, annualInterestRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format((balance)));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(
                int principal,
                float annualInterestRate,
                byte years) {

            short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
            float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;

            double mortgage;
            mortgage = principal
                    * ((monthlyInterestRate * (Math.pow(++monthlyInterestRate, numberOfPayments))) //mortgageInterestRate previously increased by 1
                    / (Math.pow(monthlyInterestRate, numberOfPayments) - 1));

            return mortgage;
    }

    public static double getPaymentSchedule(
            int principal,
            float annualInterestRate,
            byte years,
            short numberOfPaymentsMade) {

        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;
        float numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        return principal
                                * (Math.pow(++monthlyInterestRate, numberOfPayments)
                                    - (Math.pow(monthlyInterestRate,numberOfPaymentsMade)))
                                / ((Math.pow(monthlyInterestRate, numberOfPayments) - 1 ));
    }
}
