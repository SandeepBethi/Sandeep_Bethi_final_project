/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.VaccineManufacturer;

import Business.Alert;
import Business.Business;
import Business.Carton;
import Business.VaccineManfacturingOrg;
import Business.VaccinePackage;
import Business.Enterprise;
import Business.InventoryManagementOrg;
import Business.UserAccount;
import java.awt.CardLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bethi
 */
public class VaccineManufacturerWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Business business;
    UserAccount ua;

    /**
     * Creates new form InventoryManagerJPanel
     */
    public VaccineManufacturerWorkAreaJPanel(JPanel userProcessContainer, Business business, UserAccount ua) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.ua = ua;

        
 refreshWorkReqTable();

     JPanel panel = this;
        panel.setOpaque(false);
        panel.setPreferredSize(this.getPreferredSize());

    }
    ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/Resources/rsz_drug_good.jpg"));

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(icon.getImage(), 0, 0, null);
        super.paintComponent(g);
    }

    private void refreshWorkReqTable() {
        int rowCount = workReqTable.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) workReqTable.getModel()).removeRow(i);

        }
        
        
        Enterprise enterprise=business.getNetDir().getNetworkByUserAccount(ua).getEntDirectory().getEnterpriseByUserAccount(ua);
        VaccineManfacturingOrg io=(VaccineManfacturingOrg)enterprise.getOrganizationByUserAccount(ua);
        
        for (Alert a : enterprise.getAlertList()) {
            
            
            Object row[] = new Object[3];
            row[0] = a;
            if(a.getIncidentOrigin()!=null){
            row[1] = a.getIncidentOrigin();
            }
            row[2]="Passive Alert";
            


            ((DefaultTableModel) workReqTable.getModel()).addRow(row);
            

        }
        if (workReqTable.getRowCount() > 0) {
            workReqTable.changeSelection(0, 0, false, false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSentRequests = new javax.swing.JButton();
        buttonRequestVaccineLicense = new javax.swing.JButton();
        buttonWorkQueue = new javax.swing.JButton();
        buttonViewDetails = new javax.swing.JButton();
        buttonViewVaccineCatalog = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workReqTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        buttonViewSuspectedDrugs1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        buttonSentRequests.setText("Sent Requests");
        buttonSentRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSentRequestsActionPerformed(evt);
            }
        });

        buttonRequestVaccineLicense.setText("Request Vaccine License");
        buttonRequestVaccineLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRequestVaccineLicenseActionPerformed(evt);
            }
        });

        buttonWorkQueue.setText("Work Queue");
        buttonWorkQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWorkQueueActionPerformed(evt);
            }
        });

        buttonViewDetails.setText("View Personal Details");
        buttonViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewDetailsActionPerformed(evt);
            }
        });

        buttonViewVaccineCatalog.setText("View Vaccine Catalog");
        buttonViewVaccineCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewVaccineCatalogActionPerformed(evt);
            }
        });

        workReqTable.setAutoCreateRowSorter(true);
        workReqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Vaccine", "Incident Origin", "Status"
            }
        ));
        jScrollPane1.setViewportView(workReqTable);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/sign_warning.png"))); // NOI18N
        jButton2.setText("View Alert Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonViewSuspectedDrugs1.setText("View All Alerts");
        buttonViewSuspectedDrugs1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewSuspectedDrugs1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonViewDetails))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonRequestVaccineLicense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonViewVaccineCatalog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonWorkQueue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonSentRequests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonViewSuspectedDrugs1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonViewDetails)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRequestVaccineLicense)
                        .addGap(18, 18, 18)
                        .addComponent(buttonViewVaccineCatalog)
                        .addGap(18, 18, 18)
                        .addComponent(buttonWorkQueue)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSentRequests)
                        .addGap(18, 18, 18)
                        .addComponent(buttonViewSuspectedDrugs1)))
                .addContainerGap(147, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSentRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSentRequestsActionPerformed
        JPanel panel = new VaccineManufacturingSentRequestJPanel(userProcessContainer, business, ua);
        userProcessContainer.add("VaccineManufacturingSentRequestJPanel", panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_buttonSentRequestsActionPerformed

    private void buttonRequestVaccineLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRequestVaccineLicenseActionPerformed
        // TODO add your handling code here:
        JPanel panel = new RequestVaccineLicenseJPanel(userProcessContainer, business, ua);
        userProcessContainer.add("RequestVaccineLicenseJPanel", panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_buttonRequestVaccineLicenseActionPerformed

    private void buttonWorkQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWorkQueueActionPerformed
        JPanel panel = new VaccineManufacturingWorkQueueJPanel(userProcessContainer, business, ua);
        userProcessContainer.add("DrugManufacturingWorkQueueJPanel", panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_buttonWorkQueueActionPerformed

    private void buttonViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewDetailsActionPerformed
         JPanel panel = new ViewDetailsJPanel(userProcessContainer, business, ua);
        userProcessContainer.add("View Details", panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_buttonViewDetailsActionPerformed

    private void buttonViewVaccineCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewVaccineCatalogActionPerformed
JPanel panel = new VaccineCatalogJPanel(userProcessContainer, business, ua);
        userProcessContainer.add("VaccineCatalogJPanel", panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_buttonViewVaccineCatalogActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectetedRow = workReqTable.getSelectedRow();
        if(selectetedRow<0){
            JOptionPane.showMessageDialog(userProcessContainer,"Select an alert", "Select alert", 0);
            return;
        }

        Alert a=(Alert)workReqTable.getValueAt(selectetedRow, 0);
        JPanel panel = new AlertJPanel(userProcessContainer, business, ua,a);
        userProcessContainer.add("AlertJPanel", panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonViewSuspectedDrugs1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewSuspectedDrugs1ActionPerformed
JPanel panel = new AllAlertsJPanel(userProcessContainer, business, ua);
        userProcessContainer.add("AllAlertsJPanel", panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);

    }//GEN-LAST:event_buttonViewSuspectedDrugs1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRequestVaccineLicense;
    private javax.swing.JButton buttonSentRequests;
    private javax.swing.JButton buttonViewDetails;
    private javax.swing.JButton buttonViewSuspectedDrugs1;
    private javax.swing.JButton buttonViewVaccineCatalog;
    private javax.swing.JButton buttonWorkQueue;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable workReqTable;
    // End of variables declaration//GEN-END:variables
}
