package week1.module2.exercise2;
import java.util.Arrays;

class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public int compareTo(Product other) {
        return this.productId.compareTo(other.productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
class SearchAlgorithms {
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, String targetId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedProducts[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return sortedProducts[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("001", "Shirt", "Clothing"),
            new Product("002", "Pants", "Clothing"),
            new Product("003", "Shoes", "Clothing"),
            new Product("004", "Computers", "Electronics"),
            new Product("005", "Headphones", "Electronics")
        };

        Product linearResult = linearSearch(products, "003");
        System.out.println("Linear Search Result: " + linearResult);

        Arrays.sort(products);

        Product binaryResult = binarySearch(products, "003");
        System.out.println("Binary Search Result: " + binaryResult);
    }
}