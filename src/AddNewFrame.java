import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class AddNewFrame extends JFrame {

    private static final Color BEIGE = new Color(245, 245, 220); // Beige color for backgrounds
    private static final Color PINK_BRIGHTER = new Color(255, 182, 193);
    private static final Color PINK_DARKER = new Color(255, 105, 180);

    public AddNewFrame() {
        setTitle("Custom UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(BEIGE); // Set the frame's background color to beige
        setLayout(new BorderLayout(100, 0)); // Adding some space between components
        setSize(1200, 1600); // Adjust the size of the frame

        // Gradient button panel
        JPanel gradientPanel = createGradientPanel();

        // Right side - Checkboxes and characteristics
        JPanel rightPanel = createRightPanel();

        // Combine panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.add(gradientPanel);
        mainPanel.add(rightPanel);
        mainPanel.setBackground(BEIGE); // Setting the beige color for the main panel

        getContentPane().add(mainPanel);

        // Display the frame
        setVisible(true);
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
        pinkButton.setPreferredSize(new Dimension(300, 600)); // Size of the pink area, adjust as needed
        pinkButton.setBorder(new RoundedBorder(30)); // Rounded border with a radius
        pinkButton.setFocusPainted(false);
        pinkButton.setContentAreaFilled(false);
        pinkButton.setUI(new PinkButtonUI());

        // Placeholder for adding an image icon to the button
        ImageIcon icon = new ImageIcon("C:\\Users\\PC1\\IdeaProjects\\AddItem\\resources\\plus.png"); // Replace with your image path
        pinkButton.setIcon(icon);
        // If you want the icon to be smaller than the button and centered, consider using a JLabel to hold the icon

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

            }
        });

        return rightPanel;
    }

    private JPanel createCheckBoxesPanel() {
        JPanel checkboxesPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        checkboxesPanel.setBackground(BEIGE);
        checkboxesPanel.add(createCheckBoxPanelVertical("Color:", new String[]{"black", "white", "beige", "blue", "pink", "red", "green", "yellow", "orange"}));
        checkboxesPanel.add(createCheckBoxPanel("Type:", new String[]{"shirt", "pants", "skirt", "shoes", "dress", "outwear", "accessorie", "leggings"}, 2));
        checkboxesPanel.add(createCheckBoxPanelVertical("Occasion:", new String[]{"casual", "formal", "cozy", "going out"}));
        checkboxesPanel.add(createCheckBoxPanelVertical("Weather:", new String[]{"warm", "cold", "doesn't matter"}));

        return checkboxesPanel;
    }

    private void styleAddItemButton(JButton button) {
        button.setBackground(new Color(0x003366)); // Dark blue color
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(250, 50)); // Set the preferred size for the button
    }

    private static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+10, this.radius+10, this.radius+10, this.radius+10);
        }

        public boolean isBorderOpaque() {
            return false;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    // Custom UI for the button to give it a gradient background
    private static class PinkButtonUI extends BasicButtonUI {
        @Override
        public void paint(Graphics g, JComponent c) {
            super.paint(g, c);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp = new GradientPaint(0, 0, PINK_BRIGHTER, 0, c.getHeight(), PINK_DARKER);
            g2d.setPaint(gp);
            g2d.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 30, 30);
            g2d.dispose();
        }
    }

    // The following methods are defined within the class scope:

    private JPanel createCheckBoxPanelVertical(String title, String[] options) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setBackground(BEIGE);
        for (String option : options) {
            JCheckBox checkBox = new JCheckBox(option);
            checkBox.setBackground(BEIGE);
            panel.add(checkBox);
        }
        return panel;
    }

    private JPanel createCheckBoxPanel(String title, String[] options, int columns) {
        JPanel panel = new JPanel(new GridLayout(0, columns, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setBackground(BEIGE);
        for (String option : options) {
            JCheckBox checkBox = new JCheckBox(option);
            checkBox.setBackground(BEIGE);
            panel.add(checkBox);
        }
        return panel;
    }
}