package com.exchange;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CurrencyDAO dao = new CurrencyDAO();

        System.out.println("===== 🌍 Currency Exchange System =====");

        while (true) {
            System.out.print("\nEnter FROM currency (e.g., USD, INR, EUR): ");
            String from = sc.next();

            System.out.print("Enter TO currency: ");
            String to = sc.next();

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            double converted = dao.convertCurrency(from, to, amount);

            if (converted != 0)
                System.out.println("💱 " + amount + " " + from.toUpperCase() + " = " + converted + " " + to.toUpperCase());

            System.out.print("\nDo you want another conversion? (yes/no): ");
            String ch = sc.next();
            if (ch.equalsIgnoreCase("no")) break;
        }

        System.out.println("\nThank you for using Currency Exchange System!");
    }
}