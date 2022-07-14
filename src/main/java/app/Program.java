package app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import entities.Order;
import entities.OrderStatus;
import entities.Product;

public class Program {

    public static void main(String[] args) throws SQLException {

        Connection conn = DB.getConnection();

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM tb_order\n" +
                "INNER JOIN tb_order_product ON tb_order.id = tb_order_product.order_id\n" +
                "INNER JOIN tb_product ON tb_product.id = tb_order_product.product_id");

        Map<Long, Order> orderMap = new HashMap<>();
        Map<Long, Product> productMap = new HashMap<>();

        while (rs.next()) {
            Long orderId = rs.getLong("order_id");

            // Add order to orderMap only if it doesn't already exist
            if (orderMap.get(orderId) == null) {
                Order order = instantiateOrder(rs);
                orderMap.put(orderId, order);
            }

            Long productId = rs.getLong("product_id");

            // Add product to productMap only if it doesn't already exist
            if (productMap.get(productId) == null) {
                Product product = instantiateProduct(rs);
                productMap.put(productId, product);
            }

            // Add product to order's product list
            orderMap.get(orderId).getProductList().add(productMap.get(productId));
        }

        // Print each order and its products in separate blocks
        for (Long orderId : orderMap.keySet()) {
            System.out.println(orderMap.get(orderId));
            for (Product product : orderMap.get(orderId).getProductList()) {
                System.out.println(product);
            }

            System.out.println();
        }
    }

    private static Product instantiateProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("product_id"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getDouble("price"));
        product.setImageUri(rs.getString("image_uri"));

        return product;
    }

    private static Order instantiateOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("order_id"));
        order.setLatitude(rs.getString("latitude"));
        order.setLongitude(rs.getString("longitude"));
        order.setMoment(rs.getTimestamp("moment").toInstant());
        order.setStatus(OrderStatus.values()[rs.getInt("status")]);

        return order;
    }
}
