import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    JButton savedBtn, savedBtn2;

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
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Gallery", SwingConstants.CENTER);
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setFont(new Font("Candara", Font.BOLD, 50));
        lblNewLabel.setBounds(0, 20, 1200, 100);
        contentPane.add(lblNewLabel);

        startingPos = 0;
        displayClothes();

        JLabel lblNewLabel_3 = new JLabel("Back");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Candara", Font.PLAIN, 27));
        lblNewLabel_3.setBounds(50, 770, 525, 75);
        lblNewLabel_3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                startingPos -=2;
                if(startingPos < 0) startingPos += Main.clothes.size();
                displayClothes();
            }
        });
        contentPane.add(lblNewLabel_3);
        savedBtn = new JButton();
        savedBtn.setForeground(Color.WHITE);
        savedBtn.setPreferredSize(new Dimension(1000, 800)); // Size of the pink area, adjust as needed
        savedBtn.setBorder(new RoundedBorder(30)); // Rounded border with a radius
        savedBtn.setFocusPainted(false);
        savedBtn.setContentAreaFilled(false);
        savedBtn.setUI(new GradientBtn(new Color(243, 158, 186),
                new Color(236, 80, 130)));
        savedBtn.setBounds(50, 770, 525, 60);
        contentPane.add(savedBtn);


        JLabel lblNewLabel_4 = new JLabel("Next");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Candara", Font.PLAIN, 27));
        lblNewLabel_4.setBounds(625, 770, 525, 75);
        lblNewLabel_4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                startingPos +=2;
                if(startingPos >= Main.clothes.size()) startingPos -= Main.clothes.size();
                displayClothes();
            }
        });
        contentPane.add(lblNewLabel_4);
        savedBtn2 = new JButton();
        savedBtn2.setForeground(Color.WHITE);
        savedBtn2.setPreferredSize(new Dimension(1000, 800)); // Size of the pink area, adjust as needed
        savedBtn2.setBorder(new RoundedBorder(30)); // Rounded border with a radius
        savedBtn2.setFocusPainted(false);
        savedBtn2.setContentAreaFilled(false);
        savedBtn2.setUI(new GradientBtn(new Color(243, 158, 186),
                new Color(236, 80, 130)));
        savedBtn2.setBounds(625, 770, 525, 60);
        contentPane.add(savedBtn2);

        setVisible(true);
    }

    void displayClothes(){
        if(Main.clothes.size()<=6){
            for(int i = 0; i < Main.clothes.size(); i++){
                JPanel panel = displayPanel(Main.clothes.get(i));
                switch(i){
                    case 0: panel.setBounds(50, 80, 525, 200); break;
                    case 1: panel.setBounds(625, 80, 525, 200); break;
                    case 2: panel.setBounds(50, 300, 525, 200); break;
                    case 3: panel.setBounds(625, 300, 525, 200); break;
                    case 4: panel.setBounds(50, 520, 525, 200); break;
                    case 5: panel.setBounds(625, 520, 525, 200); break;
                }
                contentPane.add(panel);
            }
            savedBtn.setVisible(false);
            savedBtn2.setVisible(false);
        }
        else{
            for(int i = startingPos, pos = 0; i < startingPos + 6; i++, pos++){
                JPanel panel = displayPanel(Main.clothes.get(i%Main.clothes.size()));
                switch(pos){
                    case 0: panel.setBounds(50, 80, 525, 200); break;
                    case 1: panel.setBounds(625, 80, 525, 200); break;
                    case 2: panel.setBounds(50, 310, 525, 200); break;
                    case 3: panel.setBounds(625, 310, 525, 200); break;
                    case 4: panel.setBounds(50, 540, 525, 200); break;
                    case 5: panel.setBounds(625, 540, 525, 200); break;
                }
                contentPane.add(panel);
            }
        }
    }

    JPanel displayPanel(Item item){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel lblNewLabel_1 = new JLabel("Type: " + item.getType().toString());
        lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_1.setBounds(240, 25, 200, 40);
        panel.add(lblNewLabel_1);
        JLabel lblNewLabel_2 = new JLabel("Color: " + item.getColour().toString());
        lblNewLabel_2.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_2.setBounds(240, 60, 200, 40);
        panel.add(lblNewLabel_2);
        JLabel lblNewLabel_3 = new JLabel("Occasion: " + item.getOccasion().toString());
        lblNewLabel_3.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_3.setBounds(240, 95, 200, 40);
        panel.add(lblNewLabel_3);
        JLabel lblNewLabel_4 = new JLabel("Weather: " + item.getWeather().toString());
        lblNewLabel_4.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_4.setBounds(240, 130, 200, 40);
        panel.add(lblNewLabel_4);

        panel.setBackground(new Color(243, 225, 231));


        BufferedImage bimg = null;
        try {
            bimg = ImageIO.read(new File("resources/"+item.getPhotoPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width          = bimg.getWidth();
        int height         = bimg.getHeight();
        ImageIcon imageIcon = new ImageIcon("resources/"+item.getPhotoPath()); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image;
        if(width>height)
            newimg = image.getScaledInstance(150, Math.round(height*150/width),  Image.SCALE_DEFAULT);
        else
            newimg = image.getScaledInstance(Math.round(width*150/height), 150,  Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(newimg);

        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(45, 25, 150, 150);
        panel.add(imageLabel);
        return panel;
    }
}