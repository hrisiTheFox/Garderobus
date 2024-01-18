import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class AddNewFrame extends JFrame {

    private static final Color BEIGE = new Color(245, 245, 220); // Beige color for backgroundss

    private static Path resourceDirectory = Paths.get("resources");
    private static String absolutePath = resourceDirectory.toFile().getAbsolutePath();

    private Item newitem;

    public AddNewFrame() {
        setTitle("Custom UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(BEIGE); // Set the frame's background color to beige
        setLayout(new BorderLayout(100, 0)); // Adding some space between components
        setSize(1200, 900); // Adjust the size of the frame

        JPanel gradientPanel = createGradientPanel();

        JPanel rightPanel = createRightPanel();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.add(gradientPanel);
        mainPanel.add(rightPanel);
        mainPanel.add(rightPanel);
        mainPanel.setBackground(BEIGE); // Setting the beige color for the main panel

        getContentPane().add(mainPanel);

        newitem = new Item();
    }

    private JPanel createGradientPanel() {
        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new GridBagLayout());
        wrapperPanel.setPreferredSize(new Dimension(getWidth() / 3, getHeight())); // One third of the frame width
        wrapperPanel.setBackground(BEIGE);

        // Creating the button with a pink gradient background
        JButton pinkButton = new JButton("Choose image");
        pinkButton.setFont(new Font("Arial", Font.BOLD, 16));
        pinkButton.setForeground(Color.WHITE);
        pinkButton.setPreferredSize(new Dimension(500, 800)); // Size of the pink area, adjust as needed
        pinkButton.setBorder(new RoundedBorder(30)); // Rounded border with a radius
        pinkButton.setFocusPainted(false);
        pinkButton.setContentAreaFilled(false);
        pinkButton.setUI(new GradientBtn(new Color(255, 182, 193),
                                        new Color(255, 105, 180)));
        pinkButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser fileChooser = new JFileChooser(new File(absolutePath));
                fileChooser.addChoosableFileFilter(new ImageFilterMy());
                fileChooser.setAcceptAllFileFilterUsed(false);

                int option = fileChooser.showOpenDialog(AddNewFrame.this);
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
                    } catch (Exception ex) {
                        // TODO Auto-generated catch block
                        ex.printStackTrace();
                    }
                }else{
                    //label.setText("Open command canceled");
                }
            }
        });


        wrapperPanel.add(pinkButton); // Add the button to the wrapper panel

        return wrapperPanel;
    }

    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(BEIGE);

        JLabel characteristicsTitle = new JLabel("Characteristics");
        characteristicsTitle.setFont(new Font("Arial", Font.BOLD, 20));
        characteristicsTitle.setHorizontalAlignment(JLabel.CENTER);
        rightPanel.add(characteristicsTitle, BorderLayout.NORTH);
        JPanel checkboxesPanel = createCheckBoxesPanel();
        rightPanel.add(checkboxesPanel, BorderLayout.CENTER);

        JButton addItemButton = new JButton("Add Item");
        styleAddItemButton(addItemButton);
        rightPanel.add(addItemButton, BorderLayout.SOUTH);

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.clothes.add(newitem);
                Main.displayClothes();
            }
        });

        return rightPanel;
    }

    private JPanel createCheckBoxesPanel() {
        JPanel checkboxesPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        checkboxesPanel.setBackground(BEIGE);
        checkboxesPanel.add(createCheckBoxPanelVertical("Color:", getNames(Colour.class),0));
        checkboxesPanel.add(createCheckBoxPanel("Type:", getNames(ClothingType.class), 2,1));
        checkboxesPanel.add(createCheckBoxPanelVertical("Occasion:", getNames(Occasion.class),2));
        checkboxesPanel.add(createCheckBoxPanelVertical("Weather:", getNames(Weather.class),3));

        return checkboxesPanel;
    }

    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    private void styleAddItemButton(JButton button) {
        button.setBackground(new Color(0x003366)); // Dark blue color
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(250, 50)); // Set the preferred size for the button
    }

    private JPanel createCheckBoxPanelVertical(String title, String[] options, int propId) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setBackground(BEIGE);
        for (String option : options) {
            JCheckBox checkBox = new JCheckBox(option);
            checkBox.setBackground(BEIGE);
            checkBox.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange() == ItemEvent.SELECTED){
                        switch (propId) {
                            case 0 -> newitem.setColour(Colour.valueOf(option));
                            case 1 -> newitem.setType(ClothingType.valueOf(option));
                            case 2 -> newitem.setOccasion(Occasion.valueOf(option));
                            case 3 -> newitem.setWeather(Weather.valueOf(option));
                        }
                    }
                }
            });
            panel.add(checkBox);
        }
        return panel;
    }

    private JPanel createCheckBoxPanel(String title, String[] options, int columns, int propId) {
        JPanel panel = new JPanel(new GridLayout(0, columns, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setBackground(BEIGE);
        for (String option : options) {
            JCheckBox checkBox = new JCheckBox(option);
            checkBox.setBackground(BEIGE);
            panel.add(checkBox);

            checkBox.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange() == ItemEvent.SELECTED){
                        switch (propId) {
                            case 0 -> newitem.setColour(Colour.valueOf(option));
                            case 1 -> newitem.setType(ClothingType.valueOf(option));
                            case 2 -> newitem.setOccasion(Occasion.valueOf(option));
                            case 3 -> newitem.setWeather(Weather.valueOf(option));
                        }
                    }
                }
            });
        }
        return panel;
    }
}