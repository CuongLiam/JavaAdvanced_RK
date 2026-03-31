public class DigitalProduct extends Product {
    private double sizeInMb;

    public DigitalProduct(String id, String name, double price, double sizeInMb) {
        super(id, name, price);
        this.sizeInMb = sizeInMb;
    }

    public double getSizeInMb() {
        return sizeInMb;
    }

    public void setSizeInMb(double sizeInMb) {
        this.sizeInMb = sizeInMb;
    }

    @Override
    public void displayInfo() {
        System.out.printf(
                "[Digital] ID: %s | Name: %s | Price: %.2f | Size: %.2f MB%n",
                getId(), getName(), getPrice(), sizeInMb
        );
    }
}
