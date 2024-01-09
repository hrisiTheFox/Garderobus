public class Item {
    private Occasion occasion;
    private Type type;
    private Weather weather;
    private Colour colour;

    public Item() {
    }

    public Item(Occasion occasion, Type type, Weather weather, Colour colour) {
        this.occasion = occasion;
        this.type = type;
        this.weather = weather;
        this.colour = colour;
    }
}
