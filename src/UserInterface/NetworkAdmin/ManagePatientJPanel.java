/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package UserInterface.NetworkAdmin;

import Business.Business;
import Business.Employee;
import Business.Network;
import Business.Patient;
import Business.Roles.PatientRole;
import Business.UserAccount;
import java.awt.CardLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bethi
 */
public class ManagePatientJPanel extends javax.swing.JPanel {

    private Business b;
    private JPanel userProcessContainer;
    private UserAccount userAccount;

    /**
     * Creates new form BusinessAdminWorkAreaJPanel
     */
    public ManagePatientJPanel(JPanel upc, Business b, UserAccount ua) {
        initComponents();

        this.b = b;
        userProcessContainer = upc;
        userAccount = ua;
        refreshEmployeeTable();

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

    public void refreshEmployeeTable() {
        int rowCount = employeeJTable.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) employeeJTable.getModel()).removeRow(i);

        }

Network net=b.getNetDir().getNetworkByUserAccount(userAccount);
        for (UserAccount ua : net.getUad().getUaList()) {
if(ua.getRole().getClass().equals(PatientRole.class)){
            Object row[] = new Object[3];
            row[0] = ua.getPerson().getFirstName()+" " +ua.getPerson().getLastName();
            Patient p=(Patient)ua.getPerson();
                row[1] = p.getPatientID();
            
            
                row[2] = ua.getUserName();
            
            
                
            
            ((DefaultTableModel) employeeJTable.getModel()).addRow(row);

        }}




        if (employeeJTable.getRowCount() > 0) {
            employeeJTable.changeSelection(0, 0, true, true);
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeJTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        addEmployeeeJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Manage Patients");

        employeeJTable.setAutoCreateRowSorter(true);
        employeeJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Patient ID", "Username"
            }
        ));
        jScrollPane1.setViewportView(employeeJTable);

        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        addEmployeeeJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/add.png"))); // NOI18N
        addEmployeeeJButton.setText("Add");
        addEmployeeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeeJButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(303, 303, 303)
                        .add(jLabel2)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(backJButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(0, 0, Short.MAX_VALUE)
                                .add(addEmployeeeJButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(43, 43, 43)
                .add(jLabel2)
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 149, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(addEmployeeeJButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 179, Short.MAX_VALUE)
                .add(backJButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }
        // TODO add your handling code here:         userProcessContainer.remove(this);         CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();         cardLayout.previous(userProcessContainer);     }//GEN-LAST:event_backJButtonActionPerformed

        private void addEmployeeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeeJButtonActionPerformed

        // TODO add your handling code here:         JPanel panel = new AddEnterpriseJPanel(userProcessContainer, business, userAccount);         userProcessContainer.add("AddEnterpriseJPanel", panel);         CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();         cardLayout.next(userProcessContainer);     }//GEN-LAST:event_addEmployeeeJButtonActionPerformed

        JPanel panel = new CreatePatient(userProcessContainer, b, userAccount,this);
        userProcessContainer.add("CreatePatient", panel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmployeeeJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JTable employeeJTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
