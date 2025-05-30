package pl.shop.mock;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.shop.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class MockProductDatabase {

    private static int increment = 121;

    public static ObservableList<Product> getAllProducts() {
        return products;
    }

    public static ObservableList<Product> search(String query) {
        List<Product> filtered = products.stream()
                .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());

        return FXCollections.observableArrayList(filtered);
    }

    public static Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public static int getIncrement() {
        return increment++;
    }

    public static void add(Product product) {
        product.idProperty().set(getIncrement());
        products.add(product);
    }

    public static void edit(Product product) {
        Product p = products.stream()
                .filter(prod -> prod.getId() == product.getId())
                .findFirst()
                .orElse(null);
        if (p != null) {
            p.nameProperty().set(product.getName());
            p.quantityProperty().set(product.getQuantity());
            p.priceProperty().set(product.getPrice());
            p.categoryProperty().set(product.getCategory());
        }
    }

    public static void remove(Product product) {
        products.remove(product);
    }

    private static final ObservableList<Product> products = FXCollections.observableArrayList(
            // 1 - Spożywcze
            new Product(1, "Mleko", 15, 2.5, 1),
            new Product(2, "Chleb", 20, 3.0, 1),
            new Product(3, "Masło", 12, 4.2, 1),
            new Product(4, "Ser", 8, 5.5, 1),
            new Product(5, "Jajka", 30, 0.8, 1),
            new Product(6, "Makaron", 25, 2.2, 1),
            new Product(7, "Ryż", 18, 2.0, 1),
            new Product(8, "Kawa", 10, 12.5, 1),
            new Product(9, "Herbata", 22, 6.0, 1),
            new Product(10, "Sok pomarańczowy", 16, 4.0, 1),
            new Product(11, "Cukier", 28, 3.5, 1),
            new Product(12, "Sól", 19, 1.5, 1),
            new Product(13, "Woda mineralna", 40, 1.2, 1),
            new Product(14, "Olej", 14, 6.8, 1),
            new Product(15, "Płatki śniadaniowe", 13, 5.3, 1),
            new Product(16, "Czekolada", 17, 3.2, 1),
            new Product(17, "Zupa instant", 30, 1.8, 1),
            new Product(18, "Ketchup", 9, 4.7, 1),
            new Product(19, "Miód", 6, 10.0, 1),
            new Product(20, "Konserwa mięsna", 11, 7.4, 1),
            // 2 - Elektronika
            new Product(21, "Laptop", 4, 2500.0, 2),
            new Product(22, "Smartfon", 10, 1800.0, 2),
            new Product(23, "Tablet", 5, 1100.0, 2),
            new Product(24, "Monitor", 6, 900.0, 2),
            new Product(25, "Klawiatura", 12, 120.0, 2),
            new Product(26, "Myszka", 15, 70.0, 2),
            new Product(27, "Słuchawki", 8, 250.0, 2),
            new Product(28, "Router", 7, 150.0, 2),
            new Product(29, "Kamera internetowa", 9, 200.0, 2),
            new Product(30, "Głośnik Bluetooth", 14, 300.0, 2),
            new Product(31, "Powerbank", 10, 100.0, 2),
            new Product(32, "Dysk SSD", 5, 350.0, 2),
            new Product(33, "Pendrive", 18, 60.0, 2),
            new Product(34, "Ładowarka USB", 20, 50.0, 2),
            new Product(35, "Kabel HDMI", 13, 40.0, 2),
            new Product(36, "Zasilacz", 6, 180.0, 2),
            new Product(37, "Gimbal", 3, 400.0, 2),
            new Product(38, "Smartwatch", 7, 900.0, 2),
            new Product(39, "Odtwarzacz MP3", 11, 120.0, 2),
            new Product(40, "Projektor", 2, 2000.0, 2),
            // 3 - Moda
            new Product(41, "T-shirt", 20, 49.0, 3),
            new Product(42, "Spodnie jeansowe", 10, 120.0, 3),
            new Product(43, "Kurtka", 6, 300.0, 3),
            new Product(44, "Bluza", 15, 140.0, 3),
            new Product(45, "Sukienka", 8, 220.0, 3),
            new Product(46, "Koszula", 12, 100.0, 3),
            new Product(47, "Buty sportowe", 9, 250.0, 3),
            new Product(48, "Torba", 7, 180.0, 3),
            new Product(49, "Zegarek", 3, 450.0, 3),
            new Product(50, "Czapka", 18, 30.0, 3),
            new Product(51, "Pasek", 14, 60.0, 3),
            new Product(52, "Szalik", 13, 50.0, 3),
            new Product(53, "Skarpetki", 25, 15.0, 3),
            new Product(54, "Legginsy", 16, 80.0, 3),
            new Product(55, "Garnitur", 2, 600.0, 3),
            new Product(56, "Portfel", 10, 90.0, 3),
            new Product(57, "Okulary przeciwsłoneczne", 11, 130.0, 3),
            new Product(58, "Kolczyki", 5, 70.0, 3),
            new Product(59, "Piżama", 9, 60.0, 3),
            new Product(60, "Kapcie", 12, 40.0, 3),
            // 4 - Uroda
            new Product(61, "Krem do twarzy", 14, 45.0, 4),
            new Product(62, "Szampon", 16, 25.0, 4),
            new Product(63, "Odżywka", 10, 30.0, 4),
            new Product(64, "Perfumy", 5, 150.0, 4),
            new Product(65, "Pomadka", 8, 35.0, 4),
            new Product(66, "Tusz do rzęs", 9, 40.0, 4),
            new Product(67, "Puder", 11, 50.0, 4),
            new Product(68, "Podkład", 13, 60.0, 4),
            new Product(69, "Krem pod oczy", 7, 55.0, 4),
            new Product(70, "Maseczka", 20, 20.0, 4),
            new Product(71, "Lakiery do paznokci", 18, 15.0, 4),
            new Product(72, "Dezodorant", 22, 18.0, 4),
            new Product(73, "Balsam do ciała", 10, 35.0, 4),
            new Product(74, "Peeling", 9, 40.0, 4),
            new Product(75, "Zestaw do makijażu", 3, 200.0, 4),
            new Product(76, "Woda micelarna", 11, 28.0, 4),
            new Product(77, "Płyn do demakijażu", 6, 30.0, 4),
            new Product(78, "Korektor", 8, 33.0, 4),
            new Product(79, "Serum", 7, 70.0, 4),
            new Product(80, "Olejek do twarzy", 5, 60.0, 4),
            // 5 - Sport
            new Product(81, "Piłka nożna", 10, 80.0, 5),
            new Product(82, "Rękawice bokserskie", 5, 150.0, 5),
            new Product(83, "Bidon", 20, 25.0, 5),
            new Product(84, "Mata do jogi", 12, 90.0, 5),
            new Product(85, "Hantle", 8, 110.0, 5),
            new Product(86, "Strój sportowy", 15, 140.0, 5),
            new Product(87, "Buty biegowe", 7, 250.0, 5),
            new Product(88, "Zegarek sportowy", 4, 500.0, 5),
            new Product(89, "Torba sportowa", 9, 100.0, 5),
            new Product(90, "Rowerek stacjonarny", 2, 1500.0, 5),
            new Product(91, "Skakanka", 18, 20.0, 5),
            new Product(92, "Opaska fitness", 6, 180.0, 5),
            new Product(93, "Rolki", 5, 300.0, 5),
            new Product(94, "Kask rowerowy", 7, 120.0, 5),
            new Product(95, "Ochraniacze", 10, 60.0, 5),
            new Product(96, "Pompka rowerowa", 11, 35.0, 5),
            new Product(97, "Lina treningowa", 4, 70.0, 5),
            new Product(98, "Stepper", 3, 800.0, 5),
            new Product(99, "Kijki trekkingowe", 5, 90.0, 5),
            new Product(100, "Kamizelka obciążeniowa", 2, 350.0, 5),
            // 6 - Dom i ogród
            new Product(101, "Poduszka", 14, 40.0, 6),
            new Product(102, "Kołdra", 8, 120.0, 6),
            new Product(103, "Zasłony", 10, 90.0, 6),
            new Product(104, "Stół", 3, 700.0, 6),
            new Product(105, "Krzesło", 6, 250.0, 6),
            new Product(106, "Kwiaty doniczkowe", 9, 35.0, 6),
            new Product(107, "Doniczka", 18, 20.0, 6),
            new Product(108, "Lampka nocna", 11, 80.0, 6),
            new Product(109, "Pościel", 7, 130.0, 6),
            new Product(110, "Zestaw sztućców", 12, 60.0, 6),
            new Product(111, "Dywan", 4, 300.0, 6),
            new Product(112, "Pled", 10, 75.0, 6),
            new Product(113, "Ramka na zdjęcia", 15, 25.0, 6),
            new Product(114, "Zraszacz ogrodowy", 6, 55.0, 6),
            new Product(115, "Leżak", 5, 180.0, 6),
            new Product(116, "Kosz na pranie", 9, 45.0, 6),
            new Product(117, "Parasol ogrodowy", 3, 250.0, 6),
            new Product(118, "Skrzynka na narzędzia", 7, 85.0, 6),
            new Product(119, "Zestaw noży", 8, 100.0, 6),
            new Product(120, "Talerze porcelanowe", 10, 150.0, 6)
    );

}
