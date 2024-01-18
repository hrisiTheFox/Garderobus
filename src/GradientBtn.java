import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

class GradientBtn extends BasicButtonUI {
    Color color1;
    Color color2;
    GradientBtn(Color color1a, Color color2a){
        color1 = color1a;
        color2 = color2a;
    }
    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        Graphics2D g2d = (Graphics2D) g.create();


        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, c.getHeight(), color2);
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 30, 30);

        g2d.dispose();
    }
}

class RoundedBorder implements Border {
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