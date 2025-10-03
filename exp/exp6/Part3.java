import java.util.*;
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
        return "Product{" + "name='" + name + '\'' + ", price=" + price + ", category='" + category + '\'' + '}';
    }
}


public class Part3 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.00, "Electronics"));
        products.add(new Product("Smartphone", 800.00, "Electronics"));
        products.add(new Product("Desk Chair", 150.00, "Furniture"));
        products.add(new Product("Book", 20.00, "Books"));
        products.add(new Product("Headphones", 150.00, "Electronics"));
        products.add(new Product("Novel", 15.00, "Books"));

        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println("Category: " + category);
            productList.forEach(System.out::println);
        });

        Map<String, Optional<Product>> mostExpensiveInCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveInCategory.forEach((category, product) ->
                System.out.println(category + ": " + (product.isPresent() ? product.get().getName() : "N/A")));
        
        Double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("\nAverage price of all products: " + String.format("%.2f", averagePrice));
    }
}