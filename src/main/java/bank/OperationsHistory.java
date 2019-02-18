package bank;

import java.util.ArrayList;
import java.util.List;

class OperationsHistory {
    private List<Operation> operations;

    OperationsHistory() {
        operations = new ArrayList<Operation>();
    }

    String generateStatement() {
        StringBuilder statement = new StringBuilder();
        for (Operation operation : operations) {
            statement.append(operation.generateStatement());
        }
        return statement.toString().trim();
    }

    void add(Operation operation) {
        operations.add(operation);
    }
}
