/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InventoryManager;

import Business.Business;
import Business.Carton;
import Business.VaccinePackage;
import Business.Enterprise;
import Business.CDCEnterprise;
import Business.InventoryManagementOrg;
import Business.Network;
import Business.ReportCDCRequest;
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
public class SuspectedVaccinesJPanel extends javax.swing.JPanel {

    Business b;
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    
    

    /**
     * Creates new form InventorySentRequestJPanel
     */
    public SuspectedVaccinesJPanel(JPanel upc, Business b, UserAccount ua) {
        initComponents();

        this.b = b;
        userProcessContainer = upc;
        userAccount = ua;
        
        

        refreshWorkReqTable();
     JPanel panel = this;
        panel.setOpaque(false);
        panel.setPreferredSize(this.getPreferredSize());

    }
    ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/Resources/vaccine.jpg"));

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
        InventoryManagementOrg im=(InventoryManagementOrg)b.getNetDir().getNetworkByUserAccount(userAccount).getEnterpriseByUserAccount(userAccount).getOrganizationByUserAccount(userAccount);
        for(Carton c:im.getInvCatalog().getSuspectedCartonList()){
      

            Object row[] = new Object[4];
            row[0] = c;
            row[1] = c.getCartonId();
            row[2] = c.getPackageList().size();
            row[3] = c.getPackageList().get(0).getStatus();
            


            ((DefaultTableModel) workReqTable.getModel()).addRow(row);
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
        buttonBack = new javax.swing.JButton();
        buttonAssign = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workReqTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        suspectedTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Suspected Vaccines");

        buttonBack.setText("back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        buttonAssign.setText("Report to FDA");
        buttonAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAssignActionPerformed(evt);
            }
        });

        workReqTable.setAutoCreateRowSorter(true);
        workReqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaccine", "Carton ID", "Size", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workReqTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workReqTableMouseClicked(evt);
            }
        });
        workReqTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                workReqTableFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(workReqTable);

        suspectedTable.setAutoCreateRowSorter(true);
        suspectedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vaccine", "Package ID", "Carton ID", "Expiry Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(suspectedTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Suspected Products");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(630, 644, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(buttonBack))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAssign))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(143, 143, 143)
                .addComponent(buttonAssign)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(buttonBack)
                .addGap(67, 67, 67))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(319, Short.MAX_VALUE)))
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

Carton c=(Carton)workReqTable.getValueAt(selectetedRow, 0);

for(Network n:b.getNetDir().getNetworkList()){
    for(Enterprise ent:n.getEntDirectory().getEnterpriseList()){
        if(ent.getClass().equals(CDCEnterprise.class)){
            CDCEnterprise fent=(CDCEnterprise)ent;
            ReportCDCRequest rfr=new ReportCDCRequest();
            fent.getInvestigationOrg().getWorkQueue().addWR(rfr);
            Enterprise myEnt=b.getNetDir().getNetworkByUserAccount(userAccount).getEnterpriseByUserAccount(userAccount);
            InventoryManagementOrg im=(InventoryManagementOrg)b.getNetDir().getNetworkByUserAccount(userAccount).getEnterpriseByUserAccount(userAccount).getOrganizationByUserAccount(userAccount);
            im.getSentWorkQueue().addWR(rfr);
            
            rfr.addCarton(c);
            im.getInvCatalog().getSuspectedCartonList().remove(c);
            
            rfr.setSender(userAccount);
            rfr.setDestination(fent);
            rfr.setSource(myEnt);
            rfr.setStatus(WorkRequest.StatusType.SentToFDA.toString());
        }
        
    }
}
        

            refreshWorkReqTable();
            refreshsuspectTable(null);
        
    }//GEN-LAST:event_buttonAssignActionPerformed

    private void workReqTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_workReqTableFocusGained
       
        
    }//GEN-LAST:event_workReqTableFocusGained

    private void workReqTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workReqTableMouseClicked
       int selectetedRow = workReqTable.getSelectedRow();
        if(selectetedRow<0){
        return;
}
        Carton c=(Carton)workReqTable.getValueAt(selectetedRow, 0);
        refreshsuspectTable(c) ;
    }//GEN-LAST:event_workReqTableMouseClicked

    private void refreshsuspectTable(Carton c) {


        
        int rowCount = suspectedTable.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) suspectedTable.getModel()).removeRow(i);

        }
        if(c==null){
            return;
        }        




        for (VaccinePackage dPack : c.getPackageList()) {

            Object row[] = new Object[5];
            row[0] = dPack.getVaccine();
            row[1] = dPack.getPackageId();
            row[2] = dPack.getCartonId();
            row[3] = dPack.getDateOfExpiry().getTime().toString();
            row[4] = dPack.getStatus();


            ((DefaultTableModel) suspectedTable.getModel()).addRow(row);
        }

        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAssign;
    private javax.swing.JButton buttonBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable suspectedTable;
    private javax.swing.JTable workReqTable;
    // End of variables declaration//GEN-END:variables
}
