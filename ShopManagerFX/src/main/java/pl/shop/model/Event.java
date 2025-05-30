package pl.shop.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {

    private int id;
    private String name;
    private LocalDateTime date;

    public Event(int id, String name, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " \uD83D\uDCC5 " + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
