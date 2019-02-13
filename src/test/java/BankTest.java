import Bank.Account;
import Bank.Client;
import Bank.Money;
import org.junit.Assert;
import org.junit.Test;

public class BankTest {
    @Test
    public void US1_AClientMakeADeposit() {
        Client client = new Client("1");
        Account account = new Account(client);
        account.deposit(Money.ValueOf(1000));
        Assert.assertEquals(Money.ValueOf(1000), account.getBalance());
    }
}
