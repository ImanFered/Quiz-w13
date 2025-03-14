public class Product {
    private int id;
    private String name;
    private String description;
    private int stock;
    private double price;

    public Product(int id, String name, String description, int stock, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", stock=" + stock + ", price=" + price + "]";

    }
}
