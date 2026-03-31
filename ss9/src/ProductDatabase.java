import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDatabase {
    private static volatile ProductDatabase instance;
    private final List<Product> products;

    private ProductDatabase() {
        this.products = new ArrayList<>();
    }

    public static ProductDatabase getInstance() {
        if (instance == null) {
            synchronized (ProductDatabase.class) {
                if (instance == null) {
                    instance = new ProductDatabase();
                }
            }
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(String id) {
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        Product product = findById(id);
        if (product == null) {
            return false;
        }
        return products.remove(product);
    }
}
