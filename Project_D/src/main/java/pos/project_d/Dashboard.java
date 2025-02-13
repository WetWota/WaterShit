package pos.project_d;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Point;
import javax.swing.JPanel;
import pos.project_d.Data.AccountData;
import pos.project_d.panel.LoginPanel;

/**
 * Dashboard JFrame - Main UI after login
 */
public class Dashboard extends javax.swing.JFrame {
    
    private JPanel centerPanel;
    private AccountData accountData;

    public Dashboard(AccountData accountData) {
        this.accountData = accountData;
        initComponents(); // ✅ Initialize NetBeans auto-generated UI

        this.Menu.setDependencies(this, accountData); // ✅ Pass dependencies to Menu

        MainPanel.setVisible(false);
        Menu.setVisible(false);
        setLocationRelativeTo(null);
        
        LoginPanel loginPanel = new LoginPanel(accountData, this);
        loginPanel.setPreferredSize(new Dimension(500, 243));

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(loginPanel);

        setLayout(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setVisible(true);
    }

    public void showMainContent() {
        centerPanel.setVisible(false);
        MainPanel.setVisible(true);
        Menu.setVisible(true);
        revalidate(); 
        repaint(); 
    }
    
    public void showLoginScreen() {
        MainPanel.setVisible(false);
        Menu.setVisible(false);
        centerPanel.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        Menu = new pos.project_d.panel.Menu();
        MainPanel = new javax.swing.JPanel();
        tItleBar = new pos.project_d.panel.TItleBar();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 576));
        setResizable(false);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        tItleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tItleBarMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tItleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tItleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tItleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tItleBarMouseDragged
        Point p = evt.getLocationOnScreen();
        this.setLocation(p);
    }//GEN-LAST:event_tItleBarMouseDragged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private pos.project_d.panel.Menu Menu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private pos.project_d.panel.TItleBar tItleBar;
    // End of variables declaration//GEN-END:variables
}
