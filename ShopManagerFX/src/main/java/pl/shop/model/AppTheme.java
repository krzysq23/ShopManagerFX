package pl.shop.model;

public enum AppTheme {

    LIGHT("Jasny"),
    DARK("Ciemny");

    private final String displayName;

    AppTheme(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String toString(AppTheme theme) {
        return theme != null ? theme.getDisplayName() : "";
    }
}
