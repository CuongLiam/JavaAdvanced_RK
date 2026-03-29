package BT2.src;

public class Calculator {
    private final DiscountStrategy discountStrategy;

    public Calculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculate(double price) {
        return discountStrategy.applyDiscount(price);
    }
}
