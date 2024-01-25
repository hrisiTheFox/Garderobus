import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Characteristics extends JFrame {

    private JPanel contentPane;

    private static Path resourceDirectory = Paths.get("resources");
    private static String absolutePath = resourceDirectory.toFile().getAbsolutePath();


    JButton btnNewButton = new JButton("Add item");
    private Item newitem;

    public Characteristics() {
        setTitle("Add new item");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 900);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(240, 248, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton pinkButton = new JButton("Choose image");
        pinkButton.setFont(new Font("Arial", Font.BOLD, 16));
        pinkButton.setForeground(Color.WHITE);
        pinkButton.setPreferredSize(new Dimension(500, 800)); // Size of the pink area, adjust as needed
        pinkButton.setBorder(new RoundedBorder(30)); // Rounded border with a radius
        pinkButton.setFocusPainted(false);
        pinkButton.setContentAreaFilled(false);
        pinkButton.setUI(new GradientBtn(new Color(255, 182, 193),
                new Color(255, 105, 180)));
        pinkButton.setBounds(42,52,450,758);
        contentPane.add(pinkButton);
        pinkButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser fileChooser = new JFileChooser(new File(absolutePath));
                fileChooser.addChoosableFileFilter(new ImageFilterMy());
                fileChooser.setAcceptAllFileFilterUsed(false);

                int option = fileChooser.showOpenDialog(Characteristics.this);
                if(option == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    //label.setText("File Selected: " + file.getName());
                    try {
                        newitem.setPhotoPath(file.getName());

                        BufferedImage bimg = ImageIO.read(new File("resources/"+newitem.getPhotoPath()));
                        int width          = bimg.getWidth();
                        int height         = bimg.getHeight();

                        ImageIcon imageIcon = new ImageIcon("resources/"+file.getName()); // load the image to a imageIcon
                        Image image = imageIcon.getImage(); // transform it
                        Image newimg = image;
                        if(width<height)
                            newimg = image.getScaledInstance(500, Math.round(height*500/width),  Image.SCALE_DEFAULT);
                        else
                            newimg = image.getScaledInstance(Math.round(width*800/height), 800,  Image.SCALE_DEFAULT);
                        imageIcon = new ImageIcon(newimg);
                        pinkButton.setUI(new BasicButtonUI());
                        pinkButton.setIcon( imageIcon );

                        btnNewButton.setEnabled(true);
                        btnNewButton.setBackground(new Color(0, 0, 128));
                    } catch (Exception ex) {
                        // TODO Auto-generated catch block
                        ex.printStackTrace();
                    }
                }else{
                    //label.setText("Open command canceled");
                }
            }
        });


        ArrayList<JCheckBox> colorCB = new ArrayList<>();
        ArrayList<JCheckBox> typeCB = new ArrayList<>();
        ArrayList<JCheckBox> occCB = new ArrayList<>();
        ArrayList<JCheckBox> weathCB = new ArrayList<>();


        JCheckBox chckbxNewCheckBox = new JCheckBox("black");
        chckbxNewCheckBox.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox.setBounds(575, 228, 100, 35);
        chckbxNewCheckBox.setName("BLACK");
        colorCB.add(chckbxNewCheckBox);
        contentPane.add(chckbxNewCheckBox);

        JLabel lblNewLabel = new JLabel("CHARACTERISTICS");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 50));
        lblNewLabel.setBounds(642, 64, 413, 103);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Color:");
        lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(575, 178, 70, 36);
        contentPane.add(lblNewLabel_1);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("white");
        chckbxNewCheckBox_1.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_1.setBounds(575, 278, 100, 35);
        chckbxNewCheckBox_1.setName("WHITE");
        colorCB.add(chckbxNewCheckBox_1);
        contentPane.add(chckbxNewCheckBox_1);

        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("beige");
        chckbxNewCheckBox_2.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_2.setBounds(575, 328, 100, 35);
        contentPane.add(chckbxNewCheckBox_2);
        chckbxNewCheckBox_2.setName("BEIGE");
        colorCB.add(chckbxNewCheckBox_2);

        btnNewButton = new JButton("Add item");
        btnNewButton.setForeground(new Color(240, 248, 255));
        btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton.setFont(new Font("Candara", Font.PLAIN, 25));
        btnNewButton.setBounds(618, 747, 450, 63);
        contentPane.add(btnNewButton);
        btnNewButton.setEnabled(false);
        btnNewButton.setBackground(new Color(128, 128, 128));
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.clothes.add(newitem);
                Main.saveClothes();
                setVisible(false);
                Main.startStartFrame();
            }
        });

        JCheckBox chckbxNewCheckBox_3 = new JCheckBox("blue");
        chckbxNewCheckBox_3.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_3.setBounds(575, 378, 100, 35);
        contentPane.add(chckbxNewCheckBox_3);
        chckbxNewCheckBox_3.setName("BLUE");
        colorCB.add(chckbxNewCheckBox_3);

        JCheckBox chckbxNewCheckBox_4 = new JCheckBox("pink");
        chckbxNewCheckBox_4.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_4.setBounds(575, 428, 100, 35);
        contentPane.add(chckbxNewCheckBox_4);
        chckbxNewCheckBox_4.setName("PINK");
        colorCB.add(chckbxNewCheckBox_4);

        JCheckBox chckbxNewCheckBox_5 = new JCheckBox("red");
        chckbxNewCheckBox_5.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_5.setBounds(575, 478, 100, 35);
        contentPane.add(chckbxNewCheckBox_5);
        chckbxNewCheckBox_5.setName("RED");
        colorCB.add(chckbxNewCheckBox_5);

        JCheckBox chckbxNewCheckBox_6 = new JCheckBox("green");
        chckbxNewCheckBox_6.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_6.setBounds(575, 528, 100, 35);
        contentPane.add(chckbxNewCheckBox_6);
        chckbxNewCheckBox_6.setName("GREEN");
        colorCB.add(chckbxNewCheckBox_6);

        JCheckBox chckbxNewCheckBox_7 = new JCheckBox("yellow");
        chckbxNewCheckBox_7.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_7.setBounds(575, 578, 100, 35);
        contentPane.add(chckbxNewCheckBox_7);
        chckbxNewCheckBox_7.setName("YELLOW");
        colorCB.add(chckbxNewCheckBox_7);

        JCheckBox chckbxNewCheckBox_8 = new JCheckBox("orange");
        chckbxNewCheckBox_8.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_8.setBounds(575, 628, 100, 35);
        contentPane.add(chckbxNewCheckBox_8);
        chckbxNewCheckBox_8.setName("ORANGE");
        colorCB.add(chckbxNewCheckBox_8);

        JLabel lblNewLabel_2 = new JLabel("Type:");
        lblNewLabel_2.setFont(new Font("Candara", Font.PLAIN, 25));
        lblNewLabel_2.setBounds(790, 178, 70, 36);
        contentPane.add(lblNewLabel_2);

        JCheckBox chckbxNewCheckBox_9 = new JCheckBox("shirt");
        chckbxNewCheckBox_9.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_9.setBounds(790, 233, 100, 35);
        contentPane.add(chckbxNewCheckBox_9);
        chckbxNewCheckBox_9.setName("SHIRT");
        typeCB.add(chckbxNewCheckBox_9);

        JCheckBox chckbxNewCheckBox_10 = new JCheckBox("pants");
        chckbxNewCheckBox_10.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_10.setBounds(790, 283, 100, 35);
        contentPane.add(chckbxNewCheckBox_10);
        chckbxNewCheckBox_10.setName("PANTS");
        typeCB.add(chckbxNewCheckBox_10);

        JCheckBox chckbxNewCheckBox_11 = new JCheckBox("skirt");
        chckbxNewCheckBox_11.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_11.setBounds(790, 333, 100, 35);
        contentPane.add(chckbxNewCheckBox_11);
        chckbxNewCheckBox_11.setName("SKIRT");
        typeCB.add(chckbxNewCheckBox_11);

        JCheckBox chckbxNewCheckBox_12 = new JCheckBox("shoes");
        chckbxNewCheckBox_12.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_12.setBounds(790, 383, 100, 35);
        contentPane.add(chckbxNewCheckBox_12);
        chckbxNewCheckBox_12.setName("SHOES");
        typeCB.add(chckbxNewCheckBox_12);

        JCheckBox chckbxNewCheckBox_13 = new JCheckBox("dress");
        chckbxNewCheckBox_13.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_13.setBounds(970, 233, 100, 35);
        contentPane.add(chckbxNewCheckBox_13);
        chckbxNewCheckBox_13.setName("DRESS");
        typeCB.add(chckbxNewCheckBox_13);

        JCheckBox chckbxNewCheckBox_14 = new JCheckBox("tank top");
        chckbxNewCheckBox_14.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_14.setBounds(970, 283, 100, 35);
        contentPane.add(chckbxNewCheckBox_14);
        chckbxNewCheckBox_14.setName("TANK_TOP");
        typeCB.add(chckbxNewCheckBox_14);

        JCheckBox chckbxNewCheckBox_15 = new JCheckBox("accessories");
        chckbxNewCheckBox_15.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_15.setBounds(970, 333, 120, 35);
        contentPane.add(chckbxNewCheckBox_15);
        chckbxNewCheckBox_15.setName("ACCESSORIES");
        typeCB.add(chckbxNewCheckBox_15);

        JCheckBox chckbxNewCheckBox_16 = new JCheckBox("leggings");
        chckbxNewCheckBox_16.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_16.setBounds(970, 383, 100, 35);
        contentPane.add(chckbxNewCheckBox_16);
        chckbxNewCheckBox_16.setName("LEGGINGS");
        typeCB.add(chckbxNewCheckBox_16);

        JLabel lblNewLabel_3 = new JLabel("Occasion:");
        lblNewLabel_3.setFont(new Font("Candara", Font.PLAIN, 25));
        lblNewLabel_3.setBounds(790, 477, 120, 36);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Weather:");
        lblNewLabel_4.setFont(new Font("Candara", Font.PLAIN, 25));
        lblNewLabel_4.setBounds(970, 477, 120, 36);
        contentPane.add(lblNewLabel_4);

        JCheckBox chckbxNewCheckBox_17 = new JCheckBox("purple");
        chckbxNewCheckBox_17.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_17.setBounds(575, 678, 100, 35);
        contentPane.add(chckbxNewCheckBox_17);
        chckbxNewCheckBox_17.setName("PURPLE");
        colorCB.add(chckbxNewCheckBox_17);

        JCheckBox chckbxNewCheckBox_18 = new JCheckBox("casual");
        chckbxNewCheckBox_18.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_18.setBounds(790, 528, 100, 35);
        contentPane.add(chckbxNewCheckBox_18);
        chckbxNewCheckBox_18.setName("CASUAL");
        occCB.add(chckbxNewCheckBox_18);

        JCheckBox chckbxNewCheckBox_19 = new JCheckBox("warm");
        chckbxNewCheckBox_19.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_19.setBounds(970, 528, 100, 35);
        contentPane.add(chckbxNewCheckBox_19);
        chckbxNewCheckBox_19.setName("WARM");
        weathCB.add(chckbxNewCheckBox_19);

        JCheckBox chckbxNewCheckBox_20 = new JCheckBox("formal");
        chckbxNewCheckBox_20.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_20.setBounds(790, 578, 100, 35);
        contentPane.add(chckbxNewCheckBox_20);
        chckbxNewCheckBox_20.setName("FORMAL");
        occCB.add(chckbxNewCheckBox_20);

        JCheckBox chckbxNewCheckBox_21 = new JCheckBox("cold");
        chckbxNewCheckBox_21.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_21.setBounds(970, 578, 100, 35);
        contentPane.add(chckbxNewCheckBox_21);
        chckbxNewCheckBox_21.setName("COLD");
        weathCB.add(chckbxNewCheckBox_21);

        JCheckBox chckbxNewCheckBox_22 = new JCheckBox("cozy");
        chckbxNewCheckBox_22.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_22.setBounds(790, 628, 100, 35);
        contentPane.add(chckbxNewCheckBox_22);
        chckbxNewCheckBox_22.setName("COZY");
        occCB.add(chckbxNewCheckBox_22);

        JCheckBox chckbxNewCheckBox_23 = new JCheckBox("going out");
        chckbxNewCheckBox_23.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_23.setBounds(790, 678, 120, 35);
        contentPane.add(chckbxNewCheckBox_23);
        chckbxNewCheckBox_23.setName("GOING_OUT");
        occCB.add(chckbxNewCheckBox_23);

        JCheckBox chckbxNewCheckBox_24 = new JCheckBox("doesn't matter");
        chckbxNewCheckBox_24.setFont(new Font("Candara", Font.PLAIN, 20));
        chckbxNewCheckBox_24.setBounds(970, 628, 150, 35);
        contentPane.add(chckbxNewCheckBox_24);
        chckbxNewCheckBox_24.setName("DOES_NOT_MATTER");
        weathCB.add(chckbxNewCheckBox_24);

        for(JCheckBox cb : colorCB){
            cb.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(cb.isSelected()) {
                        newitem.setColour(Colour.valueOf(cb.getName()));
                        for (JCheckBox cb2 : colorCB) {
                            if (!cb.getName().equals(cb2.getName())) cb2.setSelected(false);
                        }
                    }
                }
            });
        }
        for(JCheckBox cb : typeCB){
            cb.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(cb.isSelected()) {
                        newitem.setType(ClothingType.valueOf(cb.getName()));
                        for (JCheckBox cb2 : typeCB) {
                            if (!cb.getName().equals(cb2.getName())) cb2.setSelected(false);
                        }
                    }
                }
            });
        }
        for(JCheckBox cb : weathCB){
            cb.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(cb.isSelected()) {
                        newitem.setWeather(Weather.valueOf(cb.getName()));
                        for (JCheckBox cb2 : weathCB) {
                            if (!cb.getName().equals(cb2.getName())) cb2.setSelected(false);
                        }
                    }
                }
            });
        }
        for(JCheckBox cb : occCB){
            cb.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(cb.isSelected()) {
                        newitem.setOccasion(Occasion.valueOf(cb.getName()));
                        for (JCheckBox cb2 : occCB) {
                            if (!cb.getName().equals(cb2.getName())) cb2.setSelected(false);
                        }
                    }
                }
            });
        }

        newitem = new Item();
        colorCB.get(0).setSelected(true);
        weathCB.get(0).setSelected(true);
        typeCB.get(0).setSelected(true);
        occCB.get(0).setSelected(true);
    }
    private JPanel createGradientPanel() {
        // TODO Auto-generated method stub
        return null;
    }
}
