package pos.project_d.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * InvoiceTableModel - Custom table model for invoices.
 */
public class InvoiceTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "Name", "Amount", "Price", "Total", "Paid",  "Status"};
    private List<Invoice> invoices;

    public InvoiceTableModel(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice invoice = invoices.get(rowIndex);
        switch (columnIndex) {
            case 0: return invoice.getId();
            case 1: return invoice.getName();
            case 2: return invoice.getAmount();
            case 3: return invoice.getPrice();
            case 4: return invoice.getTotal();
            case 5: return invoice.getStatus();
            case 6: return invoice.isPickedUp() ? "Yes" : "No";
            default: return null;
        }
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
        fireTableDataChanged(); // ✅ Refresh table without clearing it
    }
}
