package Bank;

import java.util.ArrayList;
import java.util.List;

class OperationsHistory {
    private List<Operation> operations;

    OperationsHistory() {
        operations = new ArrayList<Operation>();
    }

    String generateStatement() {
        String statement = "";
        for (Operation operation : operations) {
            statement += operation.generateStatement();
            ;
        }
        return statement.trim();
    }

    void add(Operation operation) {
        operations.add(operation);
    }
}
