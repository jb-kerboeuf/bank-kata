package Bank;

import java.util.Date;

class Operation {
    private OperationType type;
    private Date date;
    private Money amount;
    private Money balanceAfterOperation;

    Operation(OperationType type, Date date, Money amount, Money balanceAfterOperation) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.balanceAfterOperation = balanceAfterOperation;
    }

    String generateStatement() {
        String template = "Operation: %s | Date: %s | Amount: %s | Balance: %s\n";
        return String.format(template, type, date, amount, balanceAfterOperation);
    }
}
