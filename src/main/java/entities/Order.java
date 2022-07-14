package entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private String latitude;
    private String longitude;
    private Instant moment;
    private OrderStatus status;
    private List<Product> productList = new ArrayList<>();

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public double getTotal() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", moment=" + moment +
                ", status=" + status +
                ", total=" + getTotal() +
                '}';
    }
}
