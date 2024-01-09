public class Item {
    public Occasion occasion;
    public ClothingType type;
    public Weather weather;
    public Colour colour;

    public Item() {
    }

    public Item(Occasion occasion, ClothingType type, Weather weather, Colour colour) {
        this.occasion = occasion;
        this.type = type;
        this.weather = weather;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Item{" +
                "occasion=" + occasion +
                ", type=" + type +
                ", weather=" + weather +
                ", colour=" + colour +
                '}';
    }
}
