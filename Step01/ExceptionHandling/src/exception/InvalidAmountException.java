package exception;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(int amount) {
        super("Invalid amount: " + amount + ". Amount must be greater than 0");
    }
}
