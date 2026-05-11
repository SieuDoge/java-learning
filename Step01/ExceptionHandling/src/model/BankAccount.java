package model;

import exception.InvalidAmountException;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        if (balance < 0) {
            throw new InvalidAmountException(balance);
        }

        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance < 0) {
            throw new InvalidAmountException(balance);
        }

        this.balance = balance;
    }
}
