import java.util.ArrayList;

public class Main {
    public static ArrayList<Item> clothes = new ArrayList<>();
    public static void main(String args[]){
        AddNewFrame addNewFrame = new AddNewFrame();
//
    }

    public static void displayClothes(){
        for(Item item : clothes){
            System.out.println(item.toString());
        }
        GalleryFrame addNewFrame = new GalleryFrame();
    }
}
