package exception;

public class AmountNotEnoughException extends RuntimeException {
    public AmountNotEnoughException(int balance, int withdrawAmount) {
        super("Insufficient balance. Current balance: " + balance
                + ", withdraw amount: " + withdrawAmount);
    }
}
