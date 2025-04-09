import javax.swing.*;
import java.awt.*;

public class Banner extends JPanel implements Runnable {
    String str = "Your name here! ";
    Thread t;
    boolean stopFlag;

    public Banner() {
        setBackground(Color.CYAN);
        setForeground(Color.RED);
        t = new Thread(this);
        t.start();
    }

    public void run() {
        while (!stopFlag) {
            repaint();
            char ch = str.charAt(0);
            str = str.substring(1) + ch;
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(str, 50, 30);
    }

    public void stop() {
        stopFlag = true;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Banner Animation");
        Banner banner = new Banner();
        frame.add(banner);
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
