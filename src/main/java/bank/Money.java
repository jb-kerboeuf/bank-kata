package bank;

import java.util.Objects;

public class Money {
    private final double value;

    private Money(double value) {
        this.value = value;
    }

    public static Money valueOf(double value) {
        return new Money(value);
    }

    Money add(Money amountToAdd) {
        return Money.valueOf(value + amountToAdd.getValue());
    }

    Money subtract(Money amountToSubtract) {
        return Money.valueOf(value - amountToSubtract.getValue());
    }

    private double getValue() {
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
