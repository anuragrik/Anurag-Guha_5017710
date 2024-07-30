package week1.module2.exercise3;
import java.util.Arrays;

class Order implements Comparable<Order> {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public int compareTo(Order other) {
        return Double.compare(this.totalPrice, other.totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

class SortingAlgorithms {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].compareTo(orders[j + 1]) > 0) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders) {
        quickSort(orders, 0, orders.length - 1);
    }

    private static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].compareTo(pivot) <= 0) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("001", "Alice", 150.0),
            new Order("002", "Bob", 100.0),
            new Order("003", "Charlie", 200.0),
            new Order("004", "David", 75.0),
            new Order("005", "Eve", 125.0)
        };

        Order[] bubbleSortOrders = Arrays.copyOf(orders, orders.length);
        bubbleSort(bubbleSortOrders);
        System.out.println("Bubble Sort Result:");
        for (Order order : bubbleSortOrders) {
            System.out.println(order);
        }

        Order[] quickSortOrders = Arrays.copyOf(orders, orders.length);
        quickSort(quickSortOrders);
        System.out.println("\nQuick Sort Result:");
        for (Order order : quickSortOrders) {
            System.out.println(order);
        }
    }
}