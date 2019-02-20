package bank;

import java.util.ArrayList;
import java.util.List;

class OperationsHistory {
    private List<Operation> operations;

    OperationsHistory() {
        operations = new ArrayList<>();
    }

    String generateStatement() {
        String template = "Operation: %s | Date: %s | Amount: %s | Balance: %s\n";
        StringBuilder statement = new StringBuilder();
        for (Operation operation : operations) {
            statement.append(String.format(
                    template,
                    operation.getType(),
                    operation.getDate(),
                    operation.getAmount(),
                    operation.getBalanceAfterOperation()
            ));
        }
        return statement.toString().trim();
    }

    void add(Operation operation) {
        operations.add(operation);
    }
}
