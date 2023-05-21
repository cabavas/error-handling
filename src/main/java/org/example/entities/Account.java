package org.example.entities;

import org.example.exceptions.BusinessException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws BusinessException {
        validateWithdraw(amount);
        balance -= amount;
    }

    private void validateWithdraw(double amount) throws BusinessException {
        if(amount > withdrawLimit) {
            throw new BusinessException("Withdraw error: The amount exceeds withdraw limit");
        }
        if(amount > balance) {
            throw new BusinessException("Withdraw error: Not enough balance");
        }
    }
}
