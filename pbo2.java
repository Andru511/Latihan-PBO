import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class pbo2 {
    private static ArrayList<Product> products = new ArrayList<>();
    private static DefaultTableModel tableModel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Daftar Produk");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"Nama Produk", "Harga"};

        // ✅ Buat tabel read-only
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Nonaktifkan edit langsung
            }
        };

        JTable table = new JTable(tableModel);

        JTextField nameField = new JTextField(10);
        JTextField priceField = new JTextField(10);

        JButton addButton = new JButton("Tambah");
        JButton deleteButton = new JButton("Hapus");
        JButton editButton = new JButton("Edit");

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
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                products.remove(selectedRow);
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih baris yang ingin dihapus!");
            }
        });

        editButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String newName = nameField.getText();
                String priceText = priceField.getText();
                if (!newName.isEmpty() && !priceText.isEmpty()) {
                    try {
                        double newPrice = Double.parseDouble(priceText);

                        Product updatedProduct = new Product(newName, newPrice);
                        products.set(selectedRow, updatedProduct);

                        tableModel.setValueAt(newName, selectedRow, 0);
                        tableModel.setValueAt(newPrice, selectedRow, 1);

                        nameField.setText("");
                        priceField.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Harga tidak valid!");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Nama dan Harga harus diisi!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih baris yang ingin diedit!");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Nama:"));
        panel.add(nameField);
        panel.add(new JLabel("Harga:"));
        panel.add(priceField);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(editButton);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
