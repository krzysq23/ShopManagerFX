package pl.shop.model;

public enum OrderStatus {

    NEW("Nowe"),
    IN_PROGRESS("W realizacji"),
    SHIPPED("Wysłane"),
    DELIVERED("Dostarczone"),
    CANCELLED("Anulowane");

    private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
