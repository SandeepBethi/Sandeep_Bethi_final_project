/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package UserInterface.Patient;

import UserInterface.InventoryManager.*;
import Business.Business;
import Business.Carton;
import Business.DistributorEnterprise;
import Business.Vaccine;
import Business.Enterprise;
import Business.HospitalEnterprise;
import Business.InventoryManagementOrg;
import Business.ManufacturerEnterprise;
import Business.Network;
import Business.Organization;
import Business.Patient;
import Business.RequestForVaccines;
import Business.UserAccount;
import Business.WorkRequest;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bethi
 */
public class RequestForVaccinesJPanel extends javax.swing.JPanel {

    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
Business b;

    /** Creates new form BusinessAdminWorkAreaJPanel */
    public RequestForVaccinesJPanel(JPanel upc, Business b, UserAccount ua) {
        initComponents();

        this.b=b;
        userProcessContainer = upc;
        userAccount = ua;
        cmbNetwork.removeAllItems();
        for(Network n:b.getNetDir().getNetworkList()){
            cmbNetwork.addItem(n);
        }
        cmbNetwork.setSelectedIndex(0);
        
         
        
        
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
        int rowCount = vaccinecatalogTable.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) vaccinecatalogTable.getModel()).removeRow(i);

        }
      for (Network n : b.getNetDir().getNetworkList()) {
            for (Enterprise e : n.getEntDirectory().getEnterpriseList()) {

                if (e.getClass().equals(ManufacturerEnterprise.class)) {
                    ManufacturerEnterprise ment = (ManufacturerEnterprise) e;
                    for (Vaccine d : ment.getDmo().getVaccinecatalog().getVaccineList()) {

                        Object row[] = new Object[5];
                        row[0] = d;
                        row[1] = d.getType();
                        row[2] = d.getWeight();
                        row[3] = d.getVaccineLife();
                        row[4] = ment;

                        



                        ((DefaultTableModel) vaccinecatalogTable.getModel()).addRow(row);

                    }
                }
            }
        }
        
        
        if (vaccinecatalogTable.getRowCount() > 0) {
            vaccinecatalogTable.changeSelection(0, 0, true, true);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        requestTestJButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccinecatalogTable = new javax.swing.JTable();
        cmbNetwork = new javax.swing.JComboBox();
        cmbEnterprise = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Request for Vaccines");

        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/nav_left_red.png"))); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        requestTestJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ok.png"))); // NOI18N
        requestTestJButton1.setText("Submit");
        requestTestJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButton1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantity");

        vaccinecatalogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine Type", "Vaccine Weight", "Life", "Manufacturer"
            }
        ));
        jScrollPane1.setViewportView(vaccinecatalogTable);

        cmbNetwork.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNetworkActionPerformed(evt);
            }
        });

        cmbEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEnterpriseActionPerformed(evt);
            }
        });
        cmbEnterprise.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbEnterpriseFocusGained(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Network");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enterprise");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(298, 298, 298)
                        .add(jLabel1)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel2)
                                .add(18, 18, 18)
                                .add(cmbNetwork, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(30, 30, 30)
                                .add(jLabel4)
                                .add(18, 18, 18)
                                .add(cmbEnterprise, 0, 128, Short.MAX_VALUE)
                                .add(430, 430, 430))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(backJButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(requestTestJButton1))
                            .add(jScrollPane1))))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3)
                .add(18, 18, 18)
                .add(txtQuantity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {cmbEnterprise, cmbNetwork}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(61, 61, 61)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmbNetwork, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmbEnterprise, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(jLabel4))
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtQuantity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 75, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(backJButton)
                    .add(requestTestJButton1))
                .add(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void requestTestJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButton1ActionPerformed

         if(vaccinecatalogTable.getSelectedRow()<0){
    JOptionPane.showMessageDialog(userProcessContainer, "Please select a row", "Row Not Selected", 0);
    return;
}
         int temp;
         try{
        temp=Integer.parseInt(txtQuantity.getText());
        }catch(NumberFormatException e){
           JOptionPane.showMessageDialog(userProcessContainer, "Please enter a valid number", "Invalid value", 0);
           return;
        }
         
         
         
         
         HospitalEnterprise hent=null;
         int selectedRow=vaccinecatalogTable.getSelectedRow();
                    Vaccine vaccine=(Vaccine)vaccinecatalogTable.getValueAt(selectedRow, 0);
                    RequestForVaccines sr=null;
//                   if(rbManufacturer.isSelected()){
//        A:
//        for (Network net : b.getNetDir().getNetworkList()) {
//            for (Enterprise ent : net.getEntDirectory().getEnterpriseList()) {
//                if (ent.getClass().equals(ManufacturerEnterprise.class)) {
//                    ment = (ManufacturerEnterprise) ent;
//                    for (Vaccine d : ment.getDmo().getDrugcatalog().getDrugList()) {
//                        if (drug == d) {
//                            sr = new RequestForVaccines();
//                            ment.getSmo().getWorkQueue().addWR(sr);
//                            break A;
//                        }
//                    }}}}}else if(rbDistributor.isSelected()){
            hent=(HospitalEnterprise)cmbEnterprise.getSelectedItem();
            sr = new RequestForVaccines();
                    hent.getSmo().getWorkQueue().addWR(sr);
        
        if(sr!=null){
        sr.setSender(userAccount);
        sr.setVaccine(vaccine);
        sr.setReqQuantity(temp);
        sr.setStatus(WorkRequest.StatusType.AtSalesOrganization.toString());
        Patient p=(Patient)userAccount.getPerson();
        p.getSentRequests().addWR(sr);
//        Network net=b.getNetDir().getNetworkByUserAccount(userAccount);
//        
//        Enterprise e1=net.getEntDirectory().getEnterpriseByUserAccount(userAccount);
//        Organization myorg=e1.getOrganizationByUserAccount(userAccount);
//        myorg.getSentWorkQueue().addWR(sr);
        }
         
        
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_requestTestJButton1ActionPerformed

    private void cmbNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNetworkActionPerformed
       cmbEnterprise.removeAllItems();
       
       if(cmbNetwork.getSelectedIndex()<0){
           return;
       }
       Network n=(Network)cmbNetwork.getSelectedItem();
       for(Enterprise e:n.getEntDirectory().getEnterpriseList()){
           if(e.getClass().equals(HospitalEnterprise.class)){
               cmbEnterprise.addItem(e);
           }
       }
       
    }//GEN-LAST:event_cmbNetworkActionPerformed

    private void cmbEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEnterpriseActionPerformed
if(cmbEnterprise.getSelectedIndex()<0){
           return;
       }

    }//GEN-LAST:event_cmbEnterpriseActionPerformed

    private void cmbEnterpriseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbEnterpriseFocusGained
       
    }//GEN-LAST:event_cmbEnterpriseFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox cmbEnterprise;
    private javax.swing.JComboBox cmbNetwork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton requestTestJButton1;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTable vaccinecatalogTable;
    // End of variables declaration//GEN-END:variables
}
