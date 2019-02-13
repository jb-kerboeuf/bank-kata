package Bank;

import java.util.Objects;

public class Money {
    private final int value;

    private Money(int value) {
        this.value = value;
    }

    public static Money ValueOf(int value) {
        return new Money(value);
    }

    Money add(Money amountToAdd) {
        return Money.ValueOf(value + amountToAdd.getValue());
    }

    Money substract(Money amountToSubstract) {
        return Money.ValueOf(value - amountToSubstract.getValue());
    }

    private int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
