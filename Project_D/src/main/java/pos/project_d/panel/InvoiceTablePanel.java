package pos.project_d.panel;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import pos.project_d.data.InvoiceService;
import pos.project_d.model.Invoice;
import pos.project_d.model.InvoiceTableModel;

/**
 * Invoice Table Panel - Displays daily invoices with AbstractTableModel.
 */
public class InvoiceTablePanel extends JPanel {
    private JTable invoiceTable;
    private InvoiceTableModel tableModel;
    private InvoiceService invoiceService;

    public InvoiceTablePanel() {
        this.invoiceService = new InvoiceService();
        initComponents();
        loadInvoiceData();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        tableModel = new InvoiceTableModel(invoiceService.getDailyInvoices());
        invoiceTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(invoiceTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void loadInvoiceData() {
        List<Invoice> invoices = invoiceService.getDailyInvoices();
        tableModel.setInvoices(invoices); // ✅ Efficiently refresh data
    }
}
