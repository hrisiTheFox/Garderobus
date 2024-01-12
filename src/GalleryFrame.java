import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JList;

public class GalleryFrame extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

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
        JLabel lblNewLabel_1 = new JLabel("Type: dress");
        lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_1.setBounds(380, 75, 200, 40);
        contentPane.add(lblNewLabel_1);
        JLabel lblNewLabel_2 = new JLabel("Color: red");
        lblNewLabel_2.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_2.setBounds(380, 110, 200, 40);
        contentPane.add(lblNewLabel_2);
        JLabel lblNewLabel_3 = new JLabel("Occasion: formal");
        lblNewLabel_3.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_3.setBounds(380, 145, 200, 40);
        contentPane.add(lblNewLabel_3);
        JLabel lblNewLabel_4 = new JLabel("Weather: warm");
        lblNewLabel_4.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_4.setBounds(380, 180, 200, 40);
        contentPane.add(lblNewLabel_4);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 10, 10);
        contentPane.add(panel);
        ImageIcon image = new ImageIcon("C:\\Users\\smgF438\\Documents\\Garderobus\\reddress.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(78, 51, 221, 228);
        contentPane.add(imageLabel);
        JLabel lblNewLabel_6 = new JLabel("Type: dress");
        lblNewLabel_6.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_6.setBounds(933, 75, 200, 40);
        contentPane.add(lblNewLabel_6);
        JLabel lblNewLabel_7 = new JLabel("Color: red");
        lblNewLabel_7.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_7.setBounds(933, 110, 200, 40);
        contentPane.add(lblNewLabel_7);
        JLabel lblNewLabel_8 = new JLabel("Occasion: formal");
        lblNewLabel_8.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_8.setBounds(933, 145, 200, 40);
        contentPane.add(lblNewLabel_8);
        JLabel lblNewLabel_9 = new JLabel("Weather: warm");
        lblNewLabel_9.setFont(new Font("Candara", Font.PLAIN, 21));
        lblNewLabel_9.setBounds(933, 180, 200, 40);
        contentPane.add(lblNewLabel_9);
    }
}