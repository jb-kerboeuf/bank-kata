package Bank;

public class Account {
    private final Client client;
    private Money balance;

    public Account(Client client) {
        this.client = client;
        this.balance = Money.ValueOf(0);
    }

    public void deposit(Money amount) {
        balance = balance.add(amount);
    }

    public Money getBalance() {
        return balance;
    }
}
