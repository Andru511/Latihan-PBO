package Birthday;

import javax.swing.*;
import java.awt.*;

public class BirthdayGUI extends JFrame{
    public JTextField nameField = new JTextField(15);
    public JTextField dateField = new JTextField(10);
    public JButton calculateButton = new JButton("Hitung");
    public JTextArea resultArea = new JTextArea(5, 30);
    
    public BirthdayGUI(){
        setTitle("penghitung usia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel ("nama: "));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel ("tanggal: "));
        inputPanel.add(dateField);
        inputPanel.add(calculateButton);
        
        resultArea.setEditable(false);
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}