package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.UIManager;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class StartFrame extends JFrame {

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public StartFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        contentPane = new JPanel();
        contentPane.setBackground(Color.decode("#FFF5EC"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);



        JLabel lblIcon = new JLabel("");
        lblIcon.setPreferredSize(new Dimension(120, 120));
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("ressources/garderobus.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        contentPane.setLayout(null);
        lblIcon.setIcon(imageIcon);
        lblIcon.setBounds(34,10,120,120);
        contentPane.add(lblIcon);

        JLabel lblNewLabel_1 = new JLabel("Garderobus");
        lblNewLabel_1.setForeground(Color.decode("#9F958C"));
        lblNewLabel_1.setFont(new Font("Brush Script MT", Font.PLAIN, 49));
        lblNewLabel_1.setBounds(191,10,389,120);
        contentPane.add(lblNewLabel_1);



        JLabel lblNewLabel = new JLabel("Generate outfit");
        lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 31));
        lblNewLabel.setBounds(49, 160, 410, 112);
        contentPane.add(lblNewLabel);

        JButton btnNewButton_2 = new JButton("My garderobus");
        btnNewButton_2.setBounds(34, 459, 522, 270);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton = new JButton("Add new item");
        btnNewButton.setBounds(785, 141, 361, 280);
        contentPane.add(btnNewButton);

        JButton btnNewButton_2_1 = new JButton("Generate outfit"){
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, getHeight()/2, Color.decode("#528CD0"), getWidth(), getHeight()/2, Color.decode("#B0CEF0"));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());

            }

        };
        btnNewButton_2_1.setBounds(34, 141, 716, 280);
        contentPane.add(btnNewButton_2_1);

        JButton btnNewButton_1 = new JButton("Saved outfits");
        btnNewButton_1.setBounds(593, 459, 553, 270);
        contentPane.add(btnNewButton_1);


    }
}
