import Bank.Account;
import Bank.Client;
import Bank.Money;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class BankTest {
    @Test
    public void US1_AClientMakeADeposit() {
        Client client = new Client("1");
        Account account = new Account(client);
        account.deposit(Money.ValueOf(1000), new Date());
        Assert.assertEquals(Money.ValueOf(1000), account.getBalance());
    }

    @Test
    public void US2_AClientMakeAWithdrawal() {
        Client client = new Client("1");
        Account account = new Account(client, Money.ValueOf(1000));
        account.withdrawal(Money.ValueOf(200), new Date());
        Assert.assertEquals(Money.ValueOf(800), account.getBalance());
    }

    @Test
    public void US3_AClientCheckHisOrHerOperationHistory() {
        Client client = new Client("1");
        Account account = new Account(client);
        account.deposit(Money.ValueOf(1000), new Date());
        account.withdrawal(Money.ValueOf(600), new Date());
        account.deposit(Money.ValueOf(800), new Date());

        String expectedStatement = "Acceptance Test";
        Assert.assertEquals(expectedStatement, account.getStatement());
    }

    @Test
    public void UnitTest_AClientCheckHisOrHerOnlyDeposit() {
        Client client = new Client("1");
        Account account = new Account(client);
        Date date = new Date();
        account.deposit(Money.ValueOf(1000), date);
        String expectedStatement = String.format("Operation: Deposit | Date: %s | Amount: 1000 | Balance: 1000", date);
        Assert.assertEquals(expectedStatement, account.getStatement());
    }
}
