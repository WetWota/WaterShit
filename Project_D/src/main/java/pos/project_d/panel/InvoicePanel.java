package pos.project_d.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Invoice Panel - Displays invoice-related components.
 * This will be replaced with other panels (e.g., Deliveries) when switching views.
 */
public class InvoicePanel extends JPanel {
    private InvoiceTablePanel invoiceTablePanel;
    private InvoiceFormPanel invoiceFormPanel;

    public InvoicePanel() {
        initComponents(); // ✅ Initialize NetBeans-generated UI
        addComponents(); // ✅ Add components dynamically
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addComponents() {
        setLayout(new BorderLayout()); // Ensure proper layout

        invoiceTablePanel = new InvoiceTablePanel(); // ✅ Invoice Table
        invoiceFormPanel = new InvoiceFormPanel(invoiceTablePanel); // ✅ Invoice Form

        add(invoiceFormPanel, BorderLayout.NORTH); // ✅ Add Invoice Form
        add(invoiceTablePanel, BorderLayout.CENTER); // ✅ Add Invoice Table
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
