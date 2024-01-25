import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Item> clothes = new ArrayList<>();
    public static void main(String args[]){
        startStartFrame();
        clothes = (ArrayList<Item>) Item.readItemsFromFile("src/clothes.txt");
    }

    public static void saveClothes(){
        try {
            FileWriter myWriter = new FileWriter("src/clothes.txt");
            for(Item item : clothes){
                myWriter.write(item.toString()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startStartFrame(){
        StartFrame startFrame = new StartFrame();
        startFrame.setVisible(true);
    }
    public static void startCharacteristics(){
        Characteristics startFrame = new Characteristics();
        startFrame.setVisible(true);
    }
    public static void startGalleryFrame(){
        GalleryFrame startFrame = new GalleryFrame();
        startFrame.setVisible(true);
    }
}
