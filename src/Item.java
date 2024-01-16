public class Item {
    private Occasion occasion;
    private ClothingType type;
    private Weather weather;
    private Colour colour;
    private String photoPath;

    public Item() {
    }

    public Item(Occasion occasion, ClothingType type, Weather weather, Colour colour, String photoPath) {
        this.occasion = occasion;
        this.type = type;
        this.weather = weather;
        this.colour = colour;
        this.photoPath = photoPath;
    }

    public Occasion getOccasion() {
        return occasion;
    }

    public void setOccasion(Occasion occasion) {
        this.occasion = occasion;
    }

    public ClothingType getType() {
        return type;
    }

    public void setType(ClothingType type) {
        this.type = type;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
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
