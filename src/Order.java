import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private int customerId;
    private List<Product> products;
    private boolean isShipped;

    public Order(int id, int customerId, List<Product> products, boolean Shipped) {
        this.id = id;
        this.customerId = customerId;
        this.products = new ArrayList<>(products);
        this.isShipped = false;
    }

    public int getId() {
        return id;
    }

    public void markAsShipped() {
        isShipped = true;
    }
    @Override
    public String toString() {
        return "Order [id=" + id + ", customerId=" + customerId + ", products=" + products + ", isShipped=" + isShipped + "]";
    }

}
