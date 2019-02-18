package bank;

import java.util.Date;

public class Account {
    private final Client client;
    private Money balance;
    private OperationsHistory operationsHistory;

    public Account(Client client) {
        this(client, Money.valueOf(0));
    }

    public Account(Client client, Money initialDeposit) {
        this.client = client;
        this.balance = initialDeposit;
        this.operationsHistory = new OperationsHistory();
    }

    public void deposit(Money amount, Date date) {
        Money newBalance = balance.add(amount);
        balance = newBalance;
        operationsHistory.add(new Operation(OperationType.DEPOSIT, date, amount, newBalance));
    }

    public void withdrawal(Money amount, Date date) {
        Money newBalance = balance.subtract(amount);
        balance = newBalance;
        operationsHistory.add(new Operation(OperationType.WITHDRAWAL, date, amount, newBalance));
    }

    public Money getBalance() {
        return balance;
    }

    public String getStatement() {
        return operationsHistory.generateStatement();
    }
}
