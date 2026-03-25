import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        boolean isRunning = true;

        while (isRunning) {
            printMenu();
            int choice = readInt("Lua chon cua ban: ");

            switch (choice) {
                case 1:
                    handleAddProduct(productManager);
                    break;
                case 2:
                    handleDisplayProducts(productManager);
                    break;
                case 3:
                    handleUpdateQuantity(productManager);
                    break;
                case 4:
                    handleRemoveOutOfStock(productManager);
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Thoat chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon tu 1 den 5.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n========= PRODUCT MANAGEMENT SYSTEM =========");
        System.out.println("1. Them san pham moi");
        System.out.println("2. Hien thi danh sach san pham");
        System.out.println("3. Cap nhat so luong theo ID");
        System.out.println("4. Xoa san pham da het hang");
        System.out.println("5. Thoat chuong trinh");
        System.out.println("=============================================");
    }

    private static void handleAddProduct(ProductManager productManager) {
        try {
            int id = readInt("Nhap ID: ");
            String name = readNonEmptyString("Nhap ten san pham: ");
            double price = readDouble("Nhap gia san pham: ");
            int quantity = readInt("Nhap so luong ton kho: ");
            String category = readNonEmptyString("Nhap danh muc: ");

            Product newProduct = new Product(id, name, price, quantity, category);
            productManager.addProduct(newProduct);
            System.out.println("Them san pham thanh cong.");
        } catch (InvalidProductException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private static void handleDisplayProducts(ProductManager productManager) {
        List<Product> products = productManager.getProducts();
        if (products.isEmpty()) {
            System.out.println("Danh sach san pham dang trong.");
            return;
        }

        System.out.println("+------+----------------------+------------+----------+----------------+");
        System.out.println("| ID   | Name                 | Price      | Quantity | Category       |");
        System.out.println("+------+----------------------+------------+----------+----------------+");

        products.stream()
                .forEach(product -> System.out.printf(
                        "| %-4d | %-20s | %-10.2f | %-8d | %-14s |%n",
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQuantity(),
                        product.getCategory()
                ));

        System.out.println("+------+----------------------+------------+----------+----------------+");
    }

    private static void handleUpdateQuantity(ProductManager productManager) {
        try {
            int id = readInt("Nhap ID san pham can cap nhat: ");
            int newQuantity = readInt("Nhap so luong moi: ");

            productManager.updateQuantityById(id, newQuantity);
            System.out.println("Cap nhat so luong thanh cong.");
        } catch (InvalidProductException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private static void handleRemoveOutOfStock(ProductManager productManager) {
        long removedCount = productManager.removeOutOfStockProducts();
        System.out.println("Da xoa " + removedCount + " san pham het hang.");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le. Vui long nhap so nguyen.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le. Vui long nhap so thuc.");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Khong duoc de trong. Vui long nhap lai.");
        }
    }
}