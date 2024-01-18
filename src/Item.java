import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public static List<Item> readItemsFromFile(String filePath) {
        List<Item> itemList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Item item = parseItemFromLine(line);
                if (item != null) {
                    itemList.add(item);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        }


        return itemList;
    }

    private static Item parseItemFromLine(String line) {
        String[] parts = line.split(" ");
        if (parts.length == 5) { // Assuming the format is: occasion,type,weather,colour,photoPath
            Occasion occasion = Occasion.valueOf(parts[0].trim());
            ClothingType type = ClothingType.valueOf(parts[1].trim());
            Weather weather = Weather.valueOf(parts[2].trim());
            Colour colour = Colour.valueOf(parts[3].trim());
            String photoPath = parts[4].trim();

            return new Item(occasion, type, weather, colour, photoPath);
        } else {
            System.err.println("Invalid line format: " + line);
            return null;
        }
    }

    @Override
    public String toString() {
        return occasion.name() + " " + type.name() + " " +
                weather.name() + " " + colour.name() + " " + photoPath;
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

}
