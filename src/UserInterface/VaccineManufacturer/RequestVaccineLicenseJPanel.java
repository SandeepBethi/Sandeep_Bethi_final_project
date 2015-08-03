/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.VaccineManufacturer;

import Business.Business;
import Business.VaccineLicenseRequest;
import Business.Enterprise;
import Business.CDCEnterprise;
import Business.LicenseApprovalDepartment;
import Business.Network;
import Business.Organization;
import Business.UserAccount;
import java.awt.CardLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Bethi
 */
public class RequestVaccineLicenseJPanel extends javax.swing.JPanel {
JPanel userProcessContainer;
    Business business;
    UserAccount ua;
    /**
     * Creates new form RequestDrugLicenseJPanel
     */
    public RequestVaccineLicenseJPanel(JPanel userProcessContainer, Business business, UserAccount ua) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.ua = ua;
     JPanel panel = this;
        panel.setOpaque(false);
        panel.setPreferredSize(this.getPreferredSize());

    }
    ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/Resources/rsz_1blu2.jpg"));

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(icon.getImage(), 0, 0, null);
        super.paintComponent(g);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtVaccineName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtVaccineCompound = new javax.swing.JTextArea();
        buttonSubmit = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtVaccineWeight = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtVaccineType = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtShelfLife = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Request Vaccine License");

        jLabel2.setText("Vaccine Name");

        jLabel3.setText("Vaccine Compound");

        txtVaccineCompound.setColumns(20);
        txtVaccineCompound.setRows(5);
        jScrollPane1.setViewportView(txtVaccineCompound);

        buttonSubmit.setText("Submit");
        buttonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubmitActionPerformed(evt);
            }
        });

        buttonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/nav_left_red.png"))); // NOI18N
        buttonBack.setText("back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        jLabel4.setText("Vaccine Weight");

        jLabel5.setText("Vaccine Type");

        jLabel6.setText("Shelf Life");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(buttonBack)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(txtVaccineName)
                            .addComponent(txtVaccineWeight)
                            .addComponent(txtVaccineType)
                            .addComponent(txtShelfLife))))
                .addContainerGap(292, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonSubmit)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVaccineWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addComponent(txtShelfLife, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSubmit)
                    .addComponent(buttonBack))
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed

        userProcessContainer.remove(this);

        CardLayout layout= (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitActionPerformed

        CDCEnterprise fda=null;
        
        Network net=business.getNetDir().getNetworkByUserAccount(ua);
        Enterprise ent=net.getEnterpriseByUserAccount(ua);
        Organization o=ent.getOrganizationByUserAccount(ua);
for(Enterprise e:net.getEntDirectory().getEnterpriseList()){
    if(e.getClass()==CDCEnterprise.class){
        fda=(CDCEnterprise)e;
    }
}
 int temp;
         try{
        temp=Integer.parseInt(txtVaccineWeight.getText());
        }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(userProcessContainer, "Please enter a valid number", "Invalid value", 0);
           return;
        }
          int temp1;
         try{
        temp1=Integer.parseInt(txtVaccineWeight.getText());
        }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(userProcessContainer, "Please enter a valid number", "Invalid value", 0);
           return;
        }

        VaccineLicenseRequest dlr=new VaccineLicenseRequest();
        fda.getLicenseDept().getWorkQueue().addWR(dlr);
        o.getSentWorkQueue().addWR(dlr);
        
        dlr.setVaccineName(txtVaccineName.getText());
        dlr.setVaccineCompound(txtVaccineCompound.getText());
        dlr.setVaccineWeight(temp1);
        dlr.setType(txtVaccineType.getText());
        dlr.setSender(ua);
        dlr.setShelfLife(temp);
        userProcessContainer.remove(this);

        CardLayout layout= (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        

    }//GEN-LAST:event_buttonSubmitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtShelfLife;
    private javax.swing.JTextArea txtVaccineCompound;
    private javax.swing.JTextField txtVaccineName;
    private javax.swing.JTextField txtVaccineType;
    private javax.swing.JTextField txtVaccineWeight;
    // End of variables declaration//GEN-END:variables
}
