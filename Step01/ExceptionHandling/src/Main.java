import exception.AmountNotEnoughException;
import exception.InvalidAmountException;
import model.BankAccount;
import service.BankService;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);

        BankService service = new BankService();

        withdraw(service, account, -1);
        withdraw(service, account, 1500);
        withdraw(service, account, 500);
    }

    private static void withdraw(BankService service, BankAccount account, int amount) {
        try {
            service.withdraw(account, amount);

            System.out.println("Withdraw successful. Current balance: " + account.getBalance());

        } catch (InvalidAmountException | AmountNotEnoughException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
