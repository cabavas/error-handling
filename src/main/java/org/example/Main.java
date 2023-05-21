package org.example;

import org.example.entities.Account;
import org.example.exceptions.BusinessException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number;
        String holder;
        double initialBalance, withdrawLimit, amount;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        number = sc.nextInt();
        System.out.print("Holder: ");
        sc.next();
        holder = sc.nextLine();
        System.out.print("Initial balance: ");
        initialBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        withdrawLimit = sc.nextDouble();
        System.out.println();
        Account acc = new Account(number, holder, initialBalance, withdrawLimit);
        System.out.print("Enter amount for withdraw: ");
        amount = sc.nextDouble();
        try {
            acc.withdraw(amount);
            System.out.printf("New balance: %.2f", acc.getBalance());
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
        sc.close();

    }
}