package pl.shop.mock;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.shop.model.Event;

import java.time.LocalDateTime;

public class MockEventsDatabase {

    private static int increment = 4;

    public static ObservableList<Event> getAllEvents() {
        return events;
    }

    public static ObservableList<String> getAllEventsAsStringList() {
        return FXCollections.observableArrayList(events.stream().map(Event::toString).toList());
    }

    public static int getIncrement() {
        return increment++;
    }

    public static void addEvent(Event event) {
        event.setId(getIncrement());
        events.add(event);
    }

    public static ObservableList<Event> events = FXCollections.observableArrayList(
            new Event(1, "Dostawa masła", LocalDateTime.of(2025, 6, 17, 12, 0)),
            new Event(2, "Dostawa masła", LocalDateTime.of(2025, 6, 18, 15, 30)),
            new Event(3, "Spotkanie biznesowe", LocalDateTime.of(2025, 6, 19, 11, 30)),
            new Event(4, "Inwentaryzacja", LocalDateTime.of(2025, 6, 20, 12, 30))
    );
}
