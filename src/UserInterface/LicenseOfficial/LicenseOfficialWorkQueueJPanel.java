/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.LicenseOfficial;

import Business.Business;
import Business.VaccineLicenseRequest;
import Business.Enterprise;
import Business.EnterpriseLicenseApprovalRequest;
import Business.Network;
import Business.Organization;
import Business.RevokeVaccineLicenseRequestRequest;
import Business.UserAccount;
import Business.WorkRequest;
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
public class LicenseOfficialWorkQueueJPanel extends javax.swing.JPanel {

    Business b;
    private JPanel userProcessContainer;
    private UserAccount userAccount;

    /**
     * Creates new form SentRequestJPanel
     */
    public LicenseOfficialWorkQueueJPanel(JPanel upc, Business b, UserAccount ua) {
        initComponents();

        this.b = b;
        userProcessContainer = upc;
        userAccount = ua;

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

    public void refreshWorkReqTable() {
        int rowCount = workReqTable.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) workReqTable.getModel()).removeRow(i);

        }
        Network net=b.getNetDir().getNetworkByUserAccount(userAccount);
        
        Enterprise enterprise=net.getEntDirectory().getEnterpriseByUserAccount(userAccount);
        Organization o = enterprise.getOrganizationByUserAccount(userAccount);
        for (WorkRequest wr : o.getWorkQueue().getWrList()) {
            
            if(wr.getClass().equals(RevokeVaccineLicenseRequestRequest.class)){
               RevokeVaccineLicenseRequestRequest mwr = (RevokeVaccineLicenseRequestRequest) wr;
                Object row[] = new Object[6];
            row[0] = mwr;
            row[1] = WorkRequest.WRType.RevokeVaccineLicenseRequestRequest.toString();
            
            row[2] = mwr.getVaccine();
            
            row[3] = mwr.getManufacturerEnterprise();
            row[4] = mwr.getReceiver();
            row[5] = mwr.getStatus();
           
            ((DefaultTableModel) workReqTable.getModel()).addRow(row);
           }else if(wr.getClass().equals(VaccineLicenseRequest.class)){
            VaccineLicenseRequest mwr = (VaccineLicenseRequest) wr;
            Object row[] = new Object[6];
            row[0] = mwr;
            row[1] = WorkRequest.WRType.VaccineLicenseRequest.toString();
            row[2]=mwr.getVaccineName();
            row[3]=mwr.getSender();
            row[4] = mwr.getReceiver();
            row[5] = mwr.getStatus();

            ((DefaultTableModel) workReqTable.getModel()).addRow(row);
            }else if(wr.getClass().equals(EnterpriseLicenseApprovalRequest.class)){
            EnterpriseLicenseApprovalRequest mwr = (EnterpriseLicenseApprovalRequest) wr;
            Object row[] = new Object[6];
            row[0] = mwr;
            row[1] = WorkRequest.WRType.EnterpriseLicenseApprovalRequest.toString();
            row[2]=mwr.getReqEnterprise();
           
            row[5] = mwr.getStatus();

            ((DefaultTableModel) workReqTable.getModel()).addRow(row);
            }
        }
        if (workReqTable.getRowCount() > 0) {
            workReqTable.changeSelection(0, 0, true, true);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workReqTable = new javax.swing.JTable();
        buttonBack = new javax.swing.JButton();
        buttonAssign = new javax.swing.JButton();
        buttonProcess = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("License Department Work Queue");

        workReqTable.setAutoCreateRowSorter(true);
        workReqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request Date", "Type", "Vaccine Name", "Sender/Manufacturer", "Receiver", "Status"
            }
        ));
        jScrollPane1.setViewportView(workReqTable);

        buttonBack.setText("back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        buttonAssign.setText("Assign to me");
        buttonAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAssignActionPerformed(evt);
            }
        });

        buttonProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/navigate_right2.png"))); // NOI18N
        buttonProcess.setText("Process");
        buttonProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(buttonBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(buttonAssign)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonProcess)
                .addGap(141, 141, 141))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAssign)
                    .addComponent(buttonProcess))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(buttonBack)
                .addGap(67, 67, 67))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAssignActionPerformed
        int selectetedRow = workReqTable.getSelectedRow();
        if(selectetedRow<0){
    JOptionPane.showMessageDialog(userProcessContainer,"Select a request", "Select request", 0);
    return;
}
        
         WorkRequest wr = (WorkRequest) workReqTable.getValueAt(selectetedRow, 0);
        
        if(wr.getReceiver()==null){
        wr.setReceiver(userAccount);
        wr.setStatus(WorkRequest.StatusType.PendingAtLicenseDept.toString());
        refreshWorkReqTable();
        }else{
             //new ImageIcon(getClass().getResource("/UserInterface/CVSAdminRole/cvs.jpg"));
            JOptionPane.showMessageDialog(userProcessContainer,"Already assigned", "Already assigned", 1);
        }
    }//GEN-LAST:event_buttonAssignActionPerformed

    private void buttonProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcessActionPerformed

        int selectetedRow = workReqTable.getSelectedRow();
        if(selectetedRow<0){
    JOptionPane.showMessageDialog(userProcessContainer,"Select a request", "Select request", 0);
    return;
}
        
        WorkRequest wr = (WorkRequest) workReqTable.getValueAt(selectetedRow, 0);
        
        
if(wr.getReceiver()!=null){
    if(wr.getReceiver()==userAccount){
        if(wr.getStatus().equals(WorkRequest.StatusType.PendingAtLicenseDept.toString())){
         if(wr.getClass().equals(RevokeVaccineLicenseRequestRequest.class)){
               RevokeVaccineLicenseRequestRequest mwr = (RevokeVaccineLicenseRequestRequest) wr;
         
               mwr.getManufacturerEnterprise().getDmo().getVaccinecatalog().getVaccineList().remove(mwr.getVaccine());
               
               mwr.setStatus(WorkRequest.StatusType.Resolved.toString());
               
         }else if(wr.getClass().equals(VaccineLicenseRequest.class)){    
            VaccineLicenseRequest sr = (VaccineLicenseRequest)wr;
        
        JPanel panel = new VaccineLicenseRequestJPanel(userProcessContainer, b, userAccount, sr,this);
        userProcessContainer.add("ShippingRequestJPanel", panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
        
         }else if(wr.getClass().equals(EnterpriseLicenseApprovalRequest.class)){    
            EnterpriseLicenseApprovalRequest sr = (EnterpriseLicenseApprovalRequest)wr;
        
        JPanel panel = new EnterpriseLicenseRequestJPanel(userProcessContainer, b, userAccount, sr,this);
        userProcessContainer.add("ShippingRequestJPanel", panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
        
         }
         
        }else{
    JOptionPane.showMessageDialog(userProcessContainer,"Already Processed", "Already Processed", 0);
}
    }else{
    JOptionPane.showMessageDialog(userProcessContainer,"Assigned to another employee", "Already Assigned", 0);
}
}else{
    JOptionPane.showMessageDialog(userProcessContainer,"Please assign the request", "Unassigned", 0);
}
    }//GEN-LAST:event_buttonProcessActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAssign;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonProcess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable workReqTable;
    // End of variables declaration//GEN-END:variables
}
