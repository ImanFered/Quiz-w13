import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Store {
    private List<Product> products;
    private List<Customer> customers;
    private List<Order> orders;
    private Scanner scanner;

    public Store() {
        products = new ArrayList<>();
        customers = new ArrayList<>();
        orders = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    private boolean isAlphabet(String input) {
        return input != null && input.matches("[a-zA-Z\\s]+");
    }

    private boolean isPositiveInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isPositiveDouble(String input) {
        try {
            double value = Double.parseDouble(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void addProduct() {
        while (true) {
            try {
                System.out.println("Enter product name: ");
                String name = scanner.nextLine();
                if (!isAlphabet(name)) {
                    throw new IllegalArgumentException("Invalid name!");
                }
                System.out.println("Enter product description: ");
                String description = scanner.nextLine();
                System.out.println("Enter product stock quantity: ");
                String stockInput = scanner.nextLine().trim();
                if (!isPositiveInteger(stockInput)) {
                    throw new IllegalArgumentException("Invalid quantity!");
                }
                int stockQuantity = Integer.parseInt((stockInput));
                System.out.println("Enter product price: ");
                String priceInput = scanner.nextLine().trim();
                if (priceInput.isEmpty() || !isPositiveDouble(priceInput)) {
                    throw new IllegalArgumentException("Invalid price!");
                }
                double price = Double.parseDouble((priceInput));

                Product product = new Product(products.size() + 1, name, description, stockQuantity, price);
                products.add(product);
                System.out.println("Added product successfully!");
                break;
            } catch (InputMismatchException a) {
                System.out.println("Error: " + a.getMessage());
            }
        }
    }

    public void addCustomer() {
        while (true) {
            try {
                System.out.println("Enter customer name: ");
                String name = scanner.nextLine();
                if (!isAlphabet(name)) {
                    throw new IllegalArgumentException("Invalid name!");
                }
                System.out.println("Enter customer address: ");
                String address = scanner.nextLine();
                Customer customer = new Customer(customers.size() + 1, name, address);
                customers.add(customer);
                System.out.println("Added customer successfully!");
                break;
            } catch (IllegalArgumentException c) {
                System.out.println("Error: " + c.getMessage());
            }
        }
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products Available in store!");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }


    public void manageCustomers() {
        while (true) {
            try {
                System.out.println("\n manages customers: ");
                System.out.println("1.View all customers");
                System.out.println("2.Block a customers");
                System.out.println("3.Back to main menu");
                System.out.println("choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        if (customers.isEmpty()){
                            System.out.println("No customers available!");
                        }else {
                            for (Customer customer : customers) {
                                System.out.println(customer);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter customer id to block: ");
                        int customerId = scanner.nextInt();
                        scanner.nextLine();
                        boolean removed = customers.removeIf(customer -> customer.getId() == customerId);
                        if (removed) {
                            System.out.println("Customer successfully blocked!");
                        } else {
                            System.out.println("Customer not found!");
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException mc) {
                System.out.println("Invalid input! please try again!");
                scanner.nextLine();
            }
        }
    }

    public void manageOrders() {
        while (true) {
            try {
                System.out.println("\n manages orders: ");
                System.out.println("1.View all orders");
                System.out.println("2.Mark orders for shipping");
                System.out.println("3.Back to main menu");
                System.out.println("choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        if (orders.isEmpty()) {
                            System.out.println("Order List is empty!");
                        } else {
                            for (Order order : orders) {
                                System.out.println(order);
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Entrer order ID to mark as Shipped: ");
                        int orderId = scanner.nextInt();
                        scanner.nextLine();
                        boolean found = false;
                        for (Order order : orders) {
                            if (order.getId() == orderId) {
                                order.markAsShipped();
                                System.out.println("Order marked as Shipped!");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Order not found!");
                        }
                        break;
                        case 3:
                            return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (IllegalArgumentException mO) {
                System.out.println("Invalid input! please try again!");
                scanner.nextLine();
            }

        }
    }


    public void showMenu() {
        while (true) {
            System.out.println("\n MENU:");
            System.out.println("1. Add new Product");
            System.out.println("2. Add new Customer");
            System.out.println("3. Display Product");
            System.out.println("4. Manage Customers");
            System.out.println("5. Manage Orders");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        addCustomer();
                        break;
                    case 3:
                        displayProducts();
                        break;
                    case 4:
                        manageCustomers();
                    case 5:
                        manageOrders();
                    case 6:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again!");
                        scanner.nextLine();
                }
            } catch (InputMismatchException i) {
                System.out.println("Error: invalid input! Please try again! ");
                scanner.nextLine();
            }
        }
    }
}
