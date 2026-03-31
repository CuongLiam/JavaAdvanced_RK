import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDatabase database = ProductDatabase.getInstance();
        ProductFactory factory = new ProductFactory();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt(scanner, "Lua chon cua ban: ");

            switch (choice) {
                case 1:
                    createProduct(scanner, database, factory);
                    break;
                case 2:
                    displayProducts(database);
                    break;
                case 3:
                    updateProduct(scanner, database);
                    break;
                case 4:
                    deleteProduct(scanner, database);
                    break;
                case 5:
                    running = false;
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon tu 1 den 5.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n---------------------- QUAN LY SAN PHAM ----------------------");
        System.out.println("1. Them moi san pham");
        System.out.println("2. Xem danh sach san pham");
        System.out.println("3. Cap nhat thong tin san pham");
        System.out.println("4. Xoa san pham");
        System.out.println("5. Thoat");
        System.out.println("--------------------------------------------------------------");
    }

    private static void createProduct(Scanner scanner, ProductDatabase database, ProductFactory factory) {
        System.out.print("Chon loai san pham (1. Vat ly, 2. Ky thuat so): ");
        String type = scanner.nextLine().trim();

        System.out.print("Nhap ID: ");
        String id = scanner.nextLine().trim();
        if (database.findById(id) != null) {
            System.out.println("ID da ton tai. Khong the them moi.");
            return;
        }

        System.out.print("Nhap ten san pham: ");
        String name = scanner.nextLine().trim();
        double price = readDouble(scanner, "Nhap gia: ");

        double specificValue;
        if ("1".equals(type)) {
            specificValue = readDouble(scanner, "Nhap trong luong (kg): ");
        } else if ("2".equals(type)) {
            specificValue = readDouble(scanner, "Nhap dung luong (MB): ");
        } else {
            System.out.println("Loai san pham khong hop le.");
            return;
        }

        Product product = factory.createProduct(type, id, name, price, specificValue);
        if (product == null) {
            System.out.println("Khong tao duoc san pham.");
            return;
        }

        database.addProduct(product);
        System.out.println("Them san pham thanh cong.");
    }

    private static void displayProducts(ProductDatabase database) {
        List<Product> products = database.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("Danh sach san pham dang rong.");
            return;
        }

        System.out.println("\nDanh sach san pham:");
        for (Product product : products) {
            product.displayInfo();
        }
    }

    private static void updateProduct(Scanner scanner, ProductDatabase database) {
        System.out.print("Nhap ID san pham can cap nhat: ");
        String id = scanner.nextLine().trim();

        Product product = database.findById(id);
        if (product == null) {
            System.out.println("Khong tim thay san pham voi ID: " + id);
            return;
        }

        System.out.print("Nhap ten moi: ");
        String newName = scanner.nextLine().trim();
        double newPrice = readDouble(scanner, "Nhap gia moi: ");

        product.setName(newName);
        product.setPrice(newPrice);

        if (product instanceof PhysicalProduct) {
            double newWeight = readDouble(scanner, "Nhap trong luong moi (kg): ");
            ((PhysicalProduct) product).setWeight(newWeight);
        } else if (product instanceof DigitalProduct) {
            double newSize = readDouble(scanner, "Nhap dung luong moi (MB): ");
            ((DigitalProduct) product).setSizeInMb(newSize);
        }

        System.out.println("Cap nhat san pham thanh cong.");
    }

    private static void deleteProduct(Scanner scanner, ProductDatabase database) {
        System.out.print("Nhap ID san pham can xoa: ");
        String id = scanner.nextLine().trim();

        boolean deleted = database.deleteById(id);
        if (deleted) {
            System.out.println("Xoa san pham thanh cong.");
        } else {
            System.out.println("Khong tim thay san pham voi ID: " + id);
        }
    }

    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen hop le.");
            }
        }
    }

    private static double readDouble(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le.");
            }
        }
    }
}