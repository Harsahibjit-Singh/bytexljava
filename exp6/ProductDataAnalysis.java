import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
               "name='" + name + '\'' +
               ", price=" + price +
               ", category='" + category + '\'' +
               '}';
    }
}

public class ProductDataAnalysis {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.00, "Electronics"));
        products.add(new Product("Smartphone", 800.00, "Electronics"));
        products.add(new Product("Mouse", 25.00, "Electronics"));
        products.add(new Product("T-Shirt", 20.00, "Apparel"));
        products.add(new Product("Jeans", 75.00, "Apparel"));
        products.add(new Product("Novel", 15.00, "Books"));
        products.add(new Product("Textbook", 150.00, "Books"));

        System.out.println("--- 1. Grouping Products by Category ---");
        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        productsByCategory.forEach((category, productList) -> {
            System.out.println("Category: " + category);
            productList.forEach(p -> System.out.println("  - " + p.getName()));
        });

        System.out.println("\n--- 2. Most Expensive Product in Each Category ---");
        Map<String, Optional<Product>> mostExpensiveInCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));
        mostExpensiveInCategory.forEach((category, product) -> 
            product.ifPresent(p -> System.out.println(category + ": " + p.getName() + " ($" + p.getPrice() + ")"))
        );

        System.out.println("\n--- 3. Average Price of All Products ---");
        Double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.printf("Average Price: $%.2f%n", averagePrice);
    }
}
