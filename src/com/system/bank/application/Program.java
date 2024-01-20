package com.system.bank.application;

import com.system.bank.model.entities.Account;
import com.system.bank.model.exceptions.BusinessAccountException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Number: ");
            Integer numberAcc = sc.nextInt();

            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();

            System.out.print("Initial balance: ");
            Double balance = sc.nextDouble();

            System.out.print("Withdraw limit: ");
            Double withdrawLimit = sc.nextDouble();

            Account acc = new Account(numberAcc, holder, balance, withdrawLimit);

            makeWithdraw(sc, acc);

        }
        catch(InputMismatchException e){
            System.out.println("Invalid number, try again!");
        }

    }

    public static void makeWithdraw(Scanner sc, Account acc) {
        Boolean validAmountToWithdraw = false;

        while(!validAmountToWithdraw) {
            try {
                System.out.println("");
                System.out.print("Enter amount for withdraw: ");
                Double amountWithdraw = sc.nextDouble();

                acc.withdraw(amountWithdraw);

                System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));

                validAmountToWithdraw = true;

            } catch (BusinessAccountException e) {
                System.out.println("Withdraw error: " + e.getMessage());
            }
        }
    }

}
