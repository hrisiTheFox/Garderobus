import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static ArrayList<Item> clothes = new ArrayList<>();
    public static void main(String args[]){
        startStartFrame();
        clothes = (ArrayList<Item>) Item.readItemsFromFile("src/clothes.txt");

        System.out.println(gabi("5F3Z-2e-9-w", 4));
        System.out.println(gabi("2-5g-3-J", 2));
        System.out.println(gabi("--5g-3-J", 2));

        System.out.println(Arrays.toString(gabi2(new int[]{1, 2, 3, 4, 5})));
    }

    public static String gabi(String start, int k){
        String ans = "";
        int groupCount = 0;
        for(int i = start.length()-1; i>=0; i--){
            if(Character.isLetter(start.charAt(i)) || Character.isDigit(start.charAt(i))){
                ans = start.charAt(i)+ans;
                groupCount++;
                if(groupCount == k){
                    groupCount = 0;
                    ans = '-'+ans;
                }
            }
        }
        if(groupCount == 0) ans = ans.substring(1);
        return ans.toUpperCase(Locale.ROOT);
    }

    public static int[] gabi2(int[] arr){
        int[] ans = arr.clone();
        for(int i = 1; i < arr.length; i++){
            ans[i] = arr[i-1];
        }
        ans[0] = arr[arr.length-1];
        return ans;
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
