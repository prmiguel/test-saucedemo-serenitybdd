package playing.with.serenity.pages;

public enum SortingOptions {
    PRICE_LOW_TO_HIGH("Price (low to high)");

    String text;

    SortingOptions(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
