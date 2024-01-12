public class Item {
    public Occasion occasion;
    public ClothingType type;
    public Weather weather;
    public Colour colour;
    public String photoPath;

    public Item() {
    }

    public Item(Occasion occasion, ClothingType type, Weather weather, Colour colour, String photoPath) {
        this.occasion = occasion;
        this.type = type;
        this.weather = weather;
        this.colour = colour;
        this.photoPath = photoPath;
    }

    @Override
    public String toString() {
        return "Item{" +
                "occasion=" + occasion +
                ", type=" + type +
                ", weather=" + weather +
                ", colour=" + colour +
                ", photoPath=" + photoPath +
                '}';
    }
}
