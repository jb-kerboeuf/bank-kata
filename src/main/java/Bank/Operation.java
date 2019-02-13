package Bank;

import java.util.Date;

public class Operation {
    OperationType type;
    Date date;
    Money amount;
    Money balanceAfterOperation;

    public Operation(OperationType type, Date date, Money amount, Money balanceAfterOperation) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.balanceAfterOperation = balanceAfterOperation;
    }
}
