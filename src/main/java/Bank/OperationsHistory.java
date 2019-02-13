package Bank;

import java.util.ArrayList;
import java.util.List;

public class OperationsHistory {
    private List<Operation> operations;

    public OperationsHistory() {
        operations = new ArrayList<Operation>();
    }

    public String generateStatement() {
        String statement = "";
        String template = "Operation: %s | Date: %s | Amount: %s | Balance: %s\n";
        for (Operation operation : operations) {
            statement += String.format(template, operation.type, operation.date, operation.amount, operation.balanceAfterOperation);
            ;
        }
        return statement.trim();
    }

    public void add(Operation operation) {
        operations.add(operation);
    }
}
