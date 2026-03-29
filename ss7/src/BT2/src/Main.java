package BT2.src;

public class Main {
    public static void main(String[] args) {
        double total = 1000000;

        Calculator calculator = new Calculator(new NoDiscount());
        double finalNoDiscountPrice = calculator.calculate(total);
        System.out.println("Final price: " + finalNoDiscountPrice);

        Calculator calculator1 = new Calculator(new HolidayDiscount());
        double finalHolidayPrice = calculator1.calculate(total);
        System.out.println("Final price: " + finalHolidayPrice);

        Calculator calculator2 = new Calculator(new FixedDiscount(50000));
        double finalFixedPrice = calculator2.calculate(total);
        System.out.println("Final price: " + finalFixedPrice);

        Calculator calculator3 = new Calculator(new PercentageDiscount(10));
        double finalPercentagePrice = calculator3.calculate(total);
        System.out.println("Final price: " + finalPercentagePrice);
    }
}
