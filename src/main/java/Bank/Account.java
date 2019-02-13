package Bank;

public class Account {
    private final Client client;
    private Money balance;

    public Account(Client client) {
        this(client, Money.ValueOf(0));
    }

    public Account(Client client, Money initialDeposit) {
        this.client = client;
        this.balance = initialDeposit;
    }

    public void deposit(Money amount) {
        balance = balance.add(amount);
    }

    public void withdrawal(Money amount) {
        balance = balance.substract(amount);
    }

    public Money getBalance() {
        return balance;
    }
}
