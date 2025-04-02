import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Pbo2 {
    private static ArrayList<Product> products = new ArrayList<>();
    private static DefaultTableModel tableModel;

    public static void main(String[] args) {
    JFrame frame = new JFrame("Daftar Produk");
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    String[] columnNames = {"Nama Produk", "Harga"};
    tableModel = new DefaultTableModel(columnNames, 0);
    JTable table = new JTable(tableModel);

    JTextField nameField = new JTextField(10);
    JTextField priceField = new JTextField(10);

    JButton addButton = new JButton("Tambah");
    JButton deleteButton = new JButton("Hapus"); // Tambahkan tombol hapus

    addButton.addActionListener(e -> {
    String name = nameField.getText();
    double price = Double.parseDouble(priceField.getText());
    Product product = new Product(name, price);
    products.add(product);
    tableModel.addRow(new Object[]{name, price});
    nameField.setText("");
     priceField.setText("");
    });

    deleteButton.addActionListener(e -> {
    int selectedRow = table.getSelectedRow(); // Ambil baris yang dipilih
    if (selectedRow != -1) { // Pastikan ada baris yang dipilih
    products.remove(selectedRow); // Hapus dari ArrayList
    tableModel.removeRow(selectedRow); // Hapus dari tabel
    } else {
    JOptionPane.showMessageDialog(frame, "Pilih baris yang ingin dihapus!");
    }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nama:"));
        panel.add(nameField);
        panel.add(new JLabel("Harga:"));
        panel.add(priceField);
        panel.add(addButton);
        panel.add(deleteButton); // Tambahkan tombol hapus ke dalam panel

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
