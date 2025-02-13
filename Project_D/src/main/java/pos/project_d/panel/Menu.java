package pos.project_d.panel;

import javax.swing.JOptionPane;
import pos.project_d.Dashboard;
import pos.project_d.Data.AccountData;
import pos.project_d.utils.SessionManager;

/**
 * Menu Panel - Contains navigation and logout functionality
 */
public class Menu extends javax.swing.JPanel {
    private Dashboard dashboard;
    private AccountData accountData;

    public Menu() {
        initComponents();
    }

    /**
     * Sets dependencies for Dashboard and AccountData after initialization.
     */
    public void setDependencies(Dashboard dashboard, AccountData accountData) {
        this.dashboard = dashboard;
        this.accountData = accountData;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        menuItems1 = new pos.project_d.panel.MenuItems();
        LogoutBTN = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 153, 255));
        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Dacillo Waters");

        LogoutBTN.setText("Logout");
        LogoutBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(LogoutBTN)
                        .addComponent(menuItems1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(menuItems1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(LogoutBTN)
                .addGap(163, 163, 163))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBTNActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, 
    "Are you sure you want to log out?", "Confirm Logout", 
    JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        SessionManager.logout(); // ✅ Clears session

        // Close the current window
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();

        // Show login screen again
        Dashboard loginScreen = new Dashboard(new AccountData());
        loginScreen.setVisible(true);
    }
    }//GEN-LAST:event_LogoutBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogoutBTN;
    private javax.swing.JLabel jLabel1;
    private pos.project_d.panel.MenuItems menuItems1;
    // End of variables declaration//GEN-END:variables
}
