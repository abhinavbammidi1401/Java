import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

class Customer {
    String customerId;
    String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class Product {
    String productId;
    String name;

    public Product(String productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class Order {
    String orderId;
    Customer customer;
    ArrayList<Product> products;

    public Order(String orderId, Customer customer, ArrayList<Product> products) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}

public class lab7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        HashMap<String, Customer> customerMap = new HashMap<>();
        HashMap<String, Product> productMap = new HashMap<>();

        HashSet<Product> uniqueProducts = new HashSet<>();

        TreeSet<Customer> sortedCustomers = new TreeSet<>((c1, c2) -> c1.name.compareTo(c2.name));
        TreeSet<Product> sortedProducts = new TreeSet<>((p1, p2) -> p1.name.compareTo(p2.name));

        System.out.println("Welcome to Amazon CRM System!");

        // Rest of the code remains unchanged.
        // Taking user input for customers
        System.out.print("Enter the number of customers: ");
        int numCustomers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numCustomers; i++) {
            System.out.print("Enter customer ID: ");
            String customerId = scanner.nextLine();

            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            Customer customer = new Customer(customerId, customerName);
            customers.add(customer);
            customerMap.put(customerId, customer);
        }

        // Taking user input for products
        System.out.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter product ID: ");
            String productId = scanner.nextLine();

            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();

            Product product = new Product(productId, productName);
            products.add(product);
            productMap.put(productId, product);
        }

        // Taking user input for orders
        System.out.print("Enter the number of orders: ");
        int numOrders = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numOrders; i++) {
            System.out.print("Enter order ID: ");
            String orderId = scanner.nextLine();

            System.out.print("Enter customer ID for the order: ");
            String customerOrderId = scanner.nextLine();
            Customer orderCustomer = customerMap.get(customerOrderId);

            System.out.print("Enter the number of products in the order: ");
            int numOrderProducts = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            ArrayList<Product> orderProducts = new ArrayList<>();
            for (int j = 0; j < numOrderProducts; j++) {
                System.out.print("Enter product ID for product " + (j + 1) + ": ");
                String productOrderId = scanner.nextLine();
                Product orderProduct = productMap.get(productOrderId);
                orderProducts.add(orderProduct);
            }

            Order order = new Order(orderId, orderCustomer, orderProducts);
            orders.add(order);
        }

        // Displaying information
        System.out.println("\nCustomer Information: " + customers);
        System.out.println("Product Information: " + products);
        System.out.println("Order Information: " + orders);

        System.out.println("\nCustomer Map: " + customerMap);
        System.out.println("Product Map: " + productMap);

        System.out.println("\nUnique Products: " + uniqueProducts.addAll(products));

        System.out.println("\nSorted Customers: " + sortedCustomers.addAll(customers));
        System.out.println("Sorted Products: " + sortedProducts.addAll(products));

    }
}
