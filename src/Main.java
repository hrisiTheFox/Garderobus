import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static ArrayList<Item> clothes = new ArrayList<>();
    public static void main(String args[]){
        //StartFrame startFrame = new StartFrame();
        //startFrame.setVisible(true);
        Characteristics startFrame = new Characteristics();
        startFrame.setVisible(true);
        clothes = (ArrayList<Item>) Item.readItemsFromFile("src/clothes.txt");
//
    }

    public static void displayClothes(){
        for(Item item : clothes){
            System.out.println(item.toString());
        }
        GalleryFrame addNewFrame = new GalleryFrame();
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
}
