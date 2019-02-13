import Bank.Account;
import Bank.Client;
import Bank.Money;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class BankTest {
    @Test
    public void US1_AClientMakesADeposit() {
        Client client = new Client("1");
        Account account = new Account(client);
        account.deposit(Money.ValueOf(1000), new Date());
        Assert.assertEquals(Money.ValueOf(1000), account.getBalance());
    }

    @Test
    public void US2_AClientMakesAWithdrawal() {
        Client client = new Client("1");
        Account account = new Account(client, Money.ValueOf(1000));
        account.withdrawal(Money.ValueOf(200), new Date());
        Assert.assertEquals(Money.ValueOf(800), account.getBalance());
    }

    @Test
    public void US3_AClientChecksHisOrHerOperationHistory() {
        Client client = new Client("1");
        Account account = new Account(client);

        Date firstOperationDate = new Date();
        account.deposit(Money.ValueOf(1000), firstOperationDate);
        Date secondOperationDate = new Date();
        account.withdrawal(Money.ValueOf(600), secondOperationDate);
        Date thirdOperationDate = new Date();
        account.deposit(Money.ValueOf(800), thirdOperationDate);

        String expectedStatement = String.format(
                "Operation: Deposit | Date: %s | Amount: 1000 | Balance: 1000\n" +
                        "Operation: Withdrawal | Date: %s | Amount: 600 | Balance: 400\n" +
                        "Operation: Deposit | Date: %s | Amount: 800 | Balance: 1200"
                , firstOperationDate, secondOperationDate, thirdOperationDate);
        Assert.assertEquals(expectedStatement, account.getStatement());
    }

    @Test
    public void UnitTest_AClientChecksHisOrHerOnlyDeposit() {
        Client client = new Client("1");
        Account account = new Account(client);
        Date depositDate = new Date();
        account.deposit(Money.ValueOf(1000), depositDate);
        String expectedStatement = String.format("Operation: Deposit | Date: %s | Amount: 1000 | Balance: 1000", depositDate);
        Assert.assertEquals(expectedStatement, account.getStatement());
    }
}
