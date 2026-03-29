package BT2.src;

public class HolidayDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.85;
    }
}
