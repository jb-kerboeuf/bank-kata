package bank;

import java.util.Date;

class Operation {
    private final OperationType type;
    private final Date date;
    private final Money amount;
    private final Money balanceAfterOperation;

    Operation(OperationType type, Date date, Money amount, Money balanceAfterOperation) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.balanceAfterOperation = balanceAfterOperation;
    }

    OperationType getType() {
        return type;
    }

    Date getDate() {
        return date;
    }

    Money getAmount() {
        return amount;
    }

    Money getBalanceAfterOperation() {
        return balanceAfterOperation;
    }
}
