import java.awt.*;
import javax.swing.*;

public class Banner extends JPanel implements Runnable {
    String fullText = "Your name here! ";
    Thread t;
    boolean stopFlag = false;
    int startIndex = 0;
    int displayLength = 12;
    int xOffset = 50; 

    public Banner() {
        setBackground(Color.CYAN);
        setForeground(Color.RED);
        t = new Thread(this);
        t.start();
    }

    public void run() {
        while (!stopFlag) {
            startIndex = (startIndex + 1) % fullText.length();
            repaint();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("SansSerif", Font.PLAIN, 14);
        g2d.setFont(font);
        g2d.setColor(getForeground());

        String displayStr = "";
        for (int i = 0; i < displayLength; i++) {
            int idx = (startIndex + i) % fullText.length();
            displayStr += fullText.charAt(idx);
        }

        FontMetrics fm = g2d.getFontMetrics();
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

        // Geser teks ke kanan pakai xOffset
        g2d.drawString(displayStr, xOffset, y);
    }

    public void stop() {
        stopFlag = true;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Banner");
        Banner banner = new Banner();
        frame.add(banner);
        frame.setSize(250, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
