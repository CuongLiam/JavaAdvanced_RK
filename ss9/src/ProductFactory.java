public class ProductFactory {
    public Product createProduct(String type, String id, String name, double price, double specificValue) {
        switch (type) {
            case "1":
                return new PhysicalProduct(id, name, price, specificValue);
            case "2":
                return new DigitalProduct(id, name, price, specificValue);
            default:
                return null;
        }
    }
}
