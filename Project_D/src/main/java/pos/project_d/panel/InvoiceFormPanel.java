package pos.project_d.panel;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import pos.project_d.data.InvoiceService;
import pos.project_d.model.Invoice;

/**
 * Invoice Form Panel - Allows users to input and add a new invoice.
 */
public class InvoiceFormPanel extends JPanel {
    private JTextField nameField, amountField, priceField;
    private JComboBox<String> statusComboBox;
    private JCheckBox pickedUpCheckBox;
    private JButton submitButton;
    private InvoiceTablePanel invoiceTablePanel;

    public InvoiceFormPanel(InvoiceTablePanel invoiceTablePanel) {
        this.invoiceTablePanel = invoiceTablePanel;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Amount:"));
        amountField = new JTextField();
        add(amountField);

        add(new JLabel("Price :"));
        priceField = new JTextField();
        add(priceField);

        add(new JLabel("Status:"));
        statusComboBox = new JComboBox<>(new String[]{"", "Paid"});
        add(statusComboBox);

        add(new JLabel("Picked Up/Delivered:"));
        pickedUpCheckBox = new JCheckBox();
        add(pickedUpCheckBox);

        submitButton = new JButton("Add Invoice");
        submitButton.addActionListener(e -> insertInvoice());
        add(submitButton);
    }

    private void insertInvoice() {
        try {
            String name = nameField.getText();
            int amount = Integer.parseInt(amountField.getText());
            BigDecimal price = priceField.getText().isEmpty() ? null : new BigDecimal(priceField.getText());
            String status = (String) statusComboBox.getSelectedItem();
            boolean isPickedUp = pickedUpCheckBox.isSelected();

            Invoice newInvoice = new Invoice(0, name, amount, price, price == null ? BigDecimal.ZERO : price.multiply(BigDecimal.valueOf(amount)), status, isPickedUp);
            InvoiceService invoiceService = new InvoiceService();

            if (invoiceService.insertInvoice(newInvoice)) {
                JOptionPane.showMessageDialog(this, "Invoice added successfully!");
                invoiceTablePanel.loadInvoiceData(); // ✅ Refresh table after adding invoice
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add invoice.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check amount and price fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
