package service;

import exception.AmountNotEnoughException;
import exception.InvalidAmountException;
import model.BankAccount;

public class BankService {

    public void withdraw(BankAccount account, int amount) {

        if (amount <= 0) {
            throw new InvalidAmountException(amount);

        }

        if (amount > account.getBalance()) {
            throw new AmountNotEnoughException(account.getBalance(), amount);
        }

        account.setBalance(account.getBalance() - amount);
    }
}
