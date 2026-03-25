import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductManager {
    private final List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) throws InvalidProductException {
        boolean isDuplicateId = products.stream().anyMatch(p -> p.getId() == product.getId());
        if (isDuplicateId) {
            throw new InvalidProductException("ID " + product.getId() + " da ton tai trong danh sach.");
        }
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void updateQuantityById(int id, int newQuantity) throws InvalidProductException {
        Optional<Product> productOptional = products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();

        Product product = productOptional.orElseThrow(
                () -> new InvalidProductException("Khong tim thay san pham voi ID " + id + ".")
        );

        product.setQuantity(newQuantity);
    }

    public long removeOutOfStockProducts() {
        long before = products.size();
        products.removeIf(product -> product.getQuantity() == 0);
        return before - products.size();
    }
}
