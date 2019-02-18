import bank.Account;
import bank.Client;
import bank.Money;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class BankTest {
    @Test
    public void US1_AClientMakesADeposit() {
        Client client = new Client("1");
        Account account = new Account(client);
        account.deposit(Money.valueOf(1000), new Date());
        Assert.assertEquals(Money.valueOf(1000), account.getBalance());
    }

    @Test
    public void US2_AClientMakesAWithdrawal() {
        Client client = new Client("1");
        Account account = new Account(client, Money.valueOf(1000));
        account.withdrawal(Money.valueOf(200), new Date());
        Assert.assertEquals(Money.valueOf(800), account.getBalance());
    }

    @Test
    public void US3_AClientChecksHisOrHerOperationHistory() {
        Client client = new Client("1");
        Account account = new Account(client);

        Date firstOperationDate = new Date();
        account.deposit(Money.valueOf(1000), firstOperationDate);
        Date secondOperationDate = new Date();
        account.withdrawal(Money.valueOf(600), secondOperationDate);
        Date thirdOperationDate = new Date();
        account.deposit(Money.valueOf(800), thirdOperationDate);

        String expectedStatement = String.format(
                "Operation: DEPOSIT | Date: %s | Amount: 1000.0 | Balance: 1000.0\n" +
                        "Operation: WITHDRAWAL | Date: %s | Amount: 600.0 | Balance: 400.0\n" +
                        "Operation: DEPOSIT | Date: %s | Amount: 800.0 | Balance: 1200.0"
                , firstOperationDate, secondOperationDate, thirdOperationDate);
        Assert.assertEquals(expectedStatement, account.getStatement());
    }

    @Test
    public void UnitTest_AClientChecksHisOrHerOnlyDeposit() {
        Client client = new Client("1");
        Account account = new Account(client);
        Date depositDate = new Date();
        account.deposit(Money.valueOf(1000), depositDate);
        String expectedStatement = String.format("Operation: DEPOSIT | Date: %s | Amount: 1000.0 | Balance: 1000.0", depositDate);
        Assert.assertEquals(expectedStatement, account.getStatement());
    }

    @Test
    public void UnitTest_AccountBalanceGoesNegative() {
        Client client = new Client("1");
        Account account = new Account(client);
        Date date = new Date();
        account.withdrawal(Money.valueOf(1000), date);
        String expectedStatement = String.format("Operation: WITHDRAWAL | Date: %s | Amount: 1000.0 | Balance: -1000.0", date);
        Assert.assertEquals(expectedStatement, account.getStatement());
    }
}
