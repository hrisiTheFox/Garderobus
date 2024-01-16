import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JList;

public class GalleryFrame extends JFrame {

    private JPanel contentPane;
    private int startingPos;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public GalleryFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 900);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        JButton btnNewButton = new JButton("Back");
        btnNewButton.setBounds(10, 789, 344, 61);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.setLayout(null);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("Gallery");
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setBounds(10, 11, 244, 29);
        contentPane.add(lblNewLabel);

        startingPos = 0;
        displayClothes();

        setVisible(true);
    }

    void displayClothes(){
        for(int i = startingPos, pos = 0; i < Main.clothes.size(); i++, pos++){
            JPanel panel = displayPanel(Main.clothes.get(i));
            switch(pos%4){
                case 0: panel.setBounds(80, 50, 400, 400); break;
                case 1: panel.setBounds(580, 50, 400, 400); break;
                case 2: panel.setBounds(80, 550, 400, 400); break;
                case 3: panel.setBounds(580, 550, 400, 400); break;
            }
            contentPane.add(panel);
        }
    }

    JPanel displayPanel(Item item){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel lblNewLabel_1 = new JLabel("Type: " + item.getType().toString());
        lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_1.setBounds(200, 25, 200, 40);
        panel.add(lblNewLabel_1);
        JLabel lblNewLabel_2 = new JLabel("Color: " + item.getColour().toString());
        lblNewLabel_2.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_2.setBounds(200, 60, 200, 40);
        panel.add(lblNewLabel_2);
        JLabel lblNewLabel_3 = new JLabel("Occasion: " + item.getOccasion().toString());
        lblNewLabel_3.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_3.setBounds(200, 95, 200, 40);
        panel.add(lblNewLabel_3);
        JLabel lblNewLabel_4 = new JLabel("Weather: " + item.getWeather().toString());
        lblNewLabel_4.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_4.setBounds(200, 130, 200, 40);
        panel.add(lblNewLabel_4);


        BufferedImage bimg = null;
        try {
            bimg = ImageIO.read(new File(item.getPhotoPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width          = bimg.getWidth();
        int height         = bimg.getHeight();
        ImageIcon imageIcon = new ImageIcon(item.getPhotoPath()); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image;
        if(width<height)
            newimg = image.getScaledInstance(150, Math.round(height*150/width),  Image.SCALE_DEFAULT);
        else
            newimg = image.getScaledInstance(Math.round(width*200/height), 200,  Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(newimg);

        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 200, 200);
        panel.add(imageLabel);
        return panel;
    }
}