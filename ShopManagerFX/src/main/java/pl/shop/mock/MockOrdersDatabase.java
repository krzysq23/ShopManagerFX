package pl.shop.mock;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.shop.model.Order;
import pl.shop.model.OrderStatus;
import pl.shop.model.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MockOrdersDatabase {


    private static int increment = 5;

    public static ObservableList<Order> getAllOrders() {
        return orders;
    }

    public static Order findById(int id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }

    public static void add(Order order) {
        orders.add(order);
    }

    public static void remove(Order order) {
        orders.remove(order);
    }

    public static void update(Order order) {
        Order existing = findById(order.getId());
        if (existing != null) {
            int index = orders.indexOf(existing);
            orders.set(index, order);
        }
    }

    private static final ObservableList<Order> orders = FXCollections.observableArrayList(

            new Order( 1, 3, LocalDateTime.of(2025, 6,  1, 10,  0).toString(), OrderStatus.NEW,         List.of(  1,   2,   3)),
            new Order( 2, 4, LocalDateTime.of(2025, 6,  2, 11, 15).toString(), OrderStatus.IN_PROGRESS, List.of(  4,   5,   6)),
            new Order( 3, 5, LocalDateTime.of(2025, 6,  3, 12, 30).toString(), OrderStatus.SHIPPED,     List.of(  7,   8,   9)),
            new Order( 4, 6, LocalDateTime.of(2025, 6,  4, 13, 45).toString(), OrderStatus.DELIVERED,   List.of( 10,  11,  12)),
            new Order( 5, 7, LocalDateTime.of(2025, 6,  5, 14,  0).toString(), OrderStatus.CANCELLED,   List.of( 13,  14,  15)),
            new Order( 6, 8, LocalDateTime.of(2025, 6,  6, 15, 15).toString(), OrderStatus.NEW,         List.of( 16,  17,  18)),
            new Order( 7, 9, LocalDateTime.of(2025, 6,  7, 16, 30).toString(), OrderStatus.IN_PROGRESS, List.of( 19,  20,  21)),
            new Order( 8,10, LocalDateTime.of(2025, 6,  8, 17, 45).toString(), OrderStatus.SHIPPED,     List.of( 22,  23,  24)),
            new Order( 9, 3, LocalDateTime.of(2025, 6,  9, 18,  0).toString(), OrderStatus.DELIVERED,   List.of( 25,  26,  27)),
            new Order(10, 4, LocalDateTime.of(2025, 6, 10, 19, 15).toString(), OrderStatus.CANCELLED,   List.of( 28,  29,  30)),
            new Order(11, 5, LocalDateTime.of(2025, 6, 11, 10, 30).toString(), OrderStatus.NEW,         List.of( 31,  32,  33)),
            new Order(12, 6, LocalDateTime.of(2025, 6, 12, 11, 45).toString(), OrderStatus.IN_PROGRESS, List.of( 34,  35,  36)),
            new Order(13, 7, LocalDateTime.of(2025, 6, 13, 13,  0).toString(), OrderStatus.SHIPPED,     List.of( 37,  38,  39)),
            new Order(14, 8, LocalDateTime.of(2025, 6, 14, 14, 15).toString(), OrderStatus.DELIVERED,   List.of( 40,  41,  42)),
            new Order(15, 9, LocalDateTime.of(2025, 6, 15, 15, 30).toString(), OrderStatus.CANCELLED,   List.of( 43,  44,  45)),
            new Order(16,10, LocalDateTime.of(2025, 6, 16, 16, 45).toString(), OrderStatus.NEW,         List.of( 46,  47,  48)),
            new Order(17, 3, LocalDateTime.of(2025, 6, 17, 18,  0).toString(), OrderStatus.IN_PROGRESS, List.of( 49,  50,  51)),
            new Order(18, 4, LocalDateTime.of(2025, 6, 18, 19, 15).toString(), OrderStatus.SHIPPED,     List.of( 52,  53,  54)),
            new Order(19, 5, LocalDateTime.of(2025, 6, 19, 10, 30).toString(), OrderStatus.DELIVERED,   List.of( 55,  56,  57)),
            new Order(20, 6, LocalDateTime.of(2025, 6, 20, 11, 45).toString(), OrderStatus.CANCELLED,   List.of( 58,  59,  60)),
            new Order(21, 7, LocalDateTime.of(2025, 6, 21, 13,  0).toString(), OrderStatus.NEW,         List.of( 61,  62,  63)),
            new Order(22, 8, LocalDateTime.of(2025, 6, 22, 14, 15).toString(), OrderStatus.IN_PROGRESS, List.of( 64,  65,  66)),
            new Order(23, 9, LocalDateTime.of(2025, 6, 23, 15, 30).toString(), OrderStatus.SHIPPED,     List.of( 67,  68,  69)),
            new Order(24,10, LocalDateTime.of(2025, 6, 24, 16, 45).toString(), OrderStatus.DELIVERED,   List.of( 70,  71,  72)),
            new Order(25, 3, LocalDateTime.of(2025, 6, 25, 18,  0).toString(), OrderStatus.CANCELLED,   List.of( 73,  74,  75)),
            new Order(26, 4, LocalDateTime.of(2025, 6, 26, 19, 15).toString(), OrderStatus.NEW,         List.of( 76,  77,  78)),
            new Order(27, 5, LocalDateTime.of(2025, 6, 27, 10, 30).toString(), OrderStatus.IN_PROGRESS, List.of( 79,  80,  81)),
            new Order(28, 6, LocalDateTime.of(2025, 6, 28, 11, 45).toString(), OrderStatus.SHIPPED,     List.of( 82,  83,  84)),
            new Order(29, 7, LocalDateTime.of(2025, 6, 29, 13,  0).toString(), OrderStatus.DELIVERED,   List.of( 85,  86,  87)),
            new Order(30, 8, LocalDateTime.of(2025, 6, 30, 14, 15).toString(), OrderStatus.CANCELLED,   List.of( 88,  89,  90)),
            new Order(31, 9, LocalDateTime.of(2025, 6,  1, 15, 30).toString(), OrderStatus.NEW,         List.of( 91,  92,  93)),
            new Order(32,10, LocalDateTime.of(2025, 6,  2, 16, 45).toString(), OrderStatus.IN_PROGRESS, List.of( 94,  95,  96)),
            new Order(33, 3, LocalDateTime.of(2025, 6,  3, 18,  0).toString(), OrderStatus.SHIPPED,     List.of( 97,  98,  99)),
            new Order(34, 4, LocalDateTime.of(2025, 6,  4, 19, 15).toString(), OrderStatus.DELIVERED,   List.of(100, 101, 102)),
            new Order(35, 5, LocalDateTime.of(2025, 6,  5, 10, 30).toString(), OrderStatus.CANCELLED,   List.of(103, 104, 105)),
            new Order(36, 6, LocalDateTime.of(2025, 6,  6, 11, 45).toString(), OrderStatus.NEW,         List.of(106, 107, 108)),
            new Order(37, 7, LocalDateTime.of(2025, 6,  7, 13,  0).toString(), OrderStatus.IN_PROGRESS, List.of(109, 110, 111)),
            new Order(38, 8, LocalDateTime.of(2025, 6,  8, 14, 15).toString(), OrderStatus.SHIPPED,     List.of(112, 113, 114)),
            new Order(39, 9, LocalDateTime.of(2025, 6,  9, 15, 30).toString(), OrderStatus.DELIVERED,   List.of(115, 116, 117)),
            new Order(40,10, LocalDateTime.of(2025, 6, 10, 16, 45).toString(), OrderStatus.CANCELLED,   List.of(118, 119, 120)),
            new Order(41, 3, LocalDateTime.of(2025, 6, 11, 18,  0).toString(), OrderStatus.NEW,         List.of(  2,   4,   6)),
            new Order(42, 4, LocalDateTime.of(2025, 6, 12, 19, 15).toString(), OrderStatus.IN_PROGRESS, List.of(  8,  10,  12)),
            new Order(43, 5, LocalDateTime.of(2025, 6, 13, 10, 30).toString(), OrderStatus.SHIPPED,     List.of( 14,  16,  18)),
            new Order(44, 6, LocalDateTime.of(2025, 6, 14, 11, 45).toString(), OrderStatus.DELIVERED,   List.of( 20,  22,  24)),
            new Order(45, 7, LocalDateTime.of(2025, 6, 15, 13,  0).toString(), OrderStatus.CANCELLED,   List.of( 26,  28,  30)),
            new Order(46, 8, LocalDateTime.of(2025, 6, 16, 14, 15).toString(), OrderStatus.NEW,         List.of( 32,  34,  36)),
            new Order(47, 9, LocalDateTime.of(2025, 6, 17, 15, 30).toString(), OrderStatus.IN_PROGRESS, List.of( 38,  40,  42)),
            new Order(48,10, LocalDateTime.of(2025, 6, 18, 16, 45).toString(), OrderStatus.SHIPPED,     List.of( 44,  46,  48)),
            new Order(49, 3, LocalDateTime.of(2025, 6, 19, 18,  0).toString(), OrderStatus.DELIVERED,   List.of( 50,  52,  54)),
            new Order(50, 4, LocalDateTime.of(2025, 6, 20, 19, 15).toString(), OrderStatus.CANCELLED,   List.of( 56,  58,  60))
    );

}
