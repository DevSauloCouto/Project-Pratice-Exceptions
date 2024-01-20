package com.system.bank.model.entities;

import com.system.bank.model.exceptions.BusinessAccountException;

public class Account {

    private Integer numberAcc;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer numberAcc, String holder, Double balance, Double withdrawLimit) {
        this.numberAcc = numberAcc;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void withdraw(Double amount) throws BusinessAccountException {
        this.checkAmountToWithdraw(amount);
        this.balance -= amount;
    }

    public void checkAmountToWithdraw(Double amount) throws BusinessAccountException {
        if(amount > this.withdrawLimit) {
            throw new BusinessAccountException("The amount exceeds withdraw limit");
        }

        if(amount > this.balance) {
            throw new BusinessAccountException("Not enough balance");
        }
    }

}
