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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("resources/garderobus.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
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
        lblNewLabel.setFont(new Font("Candara", Font.BOLD, 31));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(75, 150, 410, 112);
        contentPane.add(lblNewLabel);

        JButton generateBtn = new JButton();
        generateBtn.setForeground(Color.WHITE);
        generateBtn.setPreferredSize(new Dimension(500, 800)); // Size of the pink area, adjust as needed
        generateBtn.setBorder(new RoundedBorder(30)); // Rounded border with a radius
        generateBtn.setFocusPainted(false);
        generateBtn.setContentAreaFilled(false);
        generateBtn.setUI(new GradientBtn(new Color(145, 189, 234),
                new Color(82, 140, 208)));
        generateBtn.setBounds(35, 140, 716, 280);
        contentPane.add(generateBtn);
        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel lblNewLabel2 = new JLabel("Add new item");
        lblNewLabel2.setFont(new Font("Candara", Font.BOLD, 31));
        lblNewLabel2.setForeground(Color.WHITE);
        lblNewLabel2.setBounds(825, 150, 410, 112);
        contentPane.add(lblNewLabel2);

        JButton addItemBtn = new JButton();
        addItemBtn.setForeground(Color.WHITE);
        addItemBtn.setPreferredSize(new Dimension(500, 800)); // Size of the pink area, adjust as needed
        addItemBtn.setBorder(new RoundedBorder(30)); // Rounded border with a radius
        addItemBtn.setFocusPainted(false);
        addItemBtn.setContentAreaFilled(false);
        addItemBtn.setUI(new GradientBtn(new Color(255, 221, 135),
                new Color(252, 197, 56)));
        addItemBtn.setBounds(785, 140, 361, 280);
        contentPane.add(addItemBtn);
        addItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.startCharacteristics();
            }
        });

        JLabel lblNewLabel3 = new JLabel("My Garderobus");
        lblNewLabel3.setFont(new Font("Candara", Font.BOLD, 31));
        lblNewLabel3.setForeground(Color.WHITE);
        lblNewLabel3.setBounds(75, 465, 410, 112);
        contentPane.add(lblNewLabel3);

        JButton gardBtn = new JButton();
        gardBtn.setForeground(Color.WHITE);
        gardBtn.setPreferredSize(new Dimension(1000, 800)); // Size of the pink area, adjust as needed
        gardBtn.setBorder(new RoundedBorder(30)); // Rounded border with a radius
        gardBtn.setFocusPainted(false);
        gardBtn.setContentAreaFilled(false);
        gardBtn.setUI(new GradientBtn(new Color(245, 160, 190),
                new Color(249, 107, 158)));
        gardBtn.setBounds(35, 455, 511, 280);
        contentPane.add(gardBtn);
        gardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.startGalleryFrame();
            }
        });

        JLabel lblNewLabel4 = new JLabel("Saved outfits");
        lblNewLabel4.setFont(new Font("Candara", Font.BOLD, 31));
        lblNewLabel4.setForeground(Color.WHITE);
        lblNewLabel4.setBounds(630, 465, 410, 112);
        contentPane.add(lblNewLabel4);

        JButton savedBtn = new JButton();
        savedBtn.setForeground(Color.WHITE);
        savedBtn.setPreferredSize(new Dimension(1000, 800)); // Size of the pink area, adjust as needed
        savedBtn.setBorder(new RoundedBorder(30)); // Rounded border with a radius
        savedBtn.setFocusPainted(false);
        savedBtn.setContentAreaFilled(false);
        savedBtn.setUI(new GradientBtn(new Color(253, 185, 123),
                new Color(250, 141, 41)));
        savedBtn.setBounds(590, 455, 553, 280);
        contentPane.add(savedBtn);
        savedBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
}
