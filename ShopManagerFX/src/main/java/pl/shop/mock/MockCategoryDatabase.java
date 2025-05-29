package pl.shop.mock;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.shop.model.Category;

import java.util.List;
import java.util.stream.Collectors;

public class MockCategoryDatabase {

    private static int increment = 120;

    public static ObservableList<Category> getAllCategories() {
        return categories;
    }

    public static ObservableList<Category> search(String query) {
        List<Category> filtered = categories.stream()
                .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());

        return FXCollections.observableArrayList(filtered);
    }

    public static int getIncrement() {
        return increment++;
    }

    public static final ObservableList<Category> categories = FXCollections.observableArrayList(
            new Category(1, "Spożywcze"),
            new Category(2, "Elektronika"),
            new Category(3, "Moda"),
            new Category(4, "Uroda"),
            new Category(5, "Sport"),
            new Category(6, "Dom i ogród")
    );
}
