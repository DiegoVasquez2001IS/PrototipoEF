/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Frm_Int_MantMarc extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_Int_MantMarc
     */
    public Frm_Int_MantMarc() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanDesk = new javax.swing.JPanel();
        JLbl1 = new javax.swing.JLabel();
        JLbl2 = new javax.swing.JLabel();
        JTxtNomMarc = new javax.swing.JTextField();
        JBtnAceptar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Agregar Nueva Marca");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Script.png"))); // NOI18N

        JPanDesk.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Marcas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel", 1, 14))); // NOI18N

        JLbl1.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl1.setText("Crear nueva marca");

        JLbl2.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl2.setText("Nombre Marca");

        JTxtNomMarc.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JBtnAceptar.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JBtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Check_16x16.png"))); // NOI18N
        JBtnAceptar.setText("Aceptar");
        JBtnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanDeskLayout = new javax.swing.GroupLayout(JPanDesk);
        JPanDesk.setLayout(JPanDeskLayout);
        JPanDeskLayout.setHorizontalGroup(
            JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanDeskLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanDeskLayout.createSequentialGroup()
                        .addComponent(JLbl1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanDeskLayout.createSequentialGroup()
                        .addGap(0, 85, Short.MAX_VALUE)
                        .addGroup(JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JLbl2)
                                .addGroup(JPanDeskLayout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(JTxtNomMarc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(JBtnAceptar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(84, 84, 84))))
        );
        JPanDeskLayout.setVerticalGroup(
            JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanDeskLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLbl1)
                .addGap(48, 48, 48)
                .addComponent(JLbl2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTxtNomMarc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanDesk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanDesk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnAceptarActionPerformed
        if(!JTxtNomMarc.getText().equals(""))
        {
            try
            {
                Conexion con = new Conexion();
                Connection cn = con.getConexion();
                PreparedStatement ps = cn.prepareStatement("INSERT INTO marca VALUES(?,?)");
                String nombreMarca=JTxtNomMarc.getText();
                ps.setString(1, "0");
                ps.setString(2, nombreMarca);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Marca Registrada", "Información", JOptionPane.INFORMATION_MESSAGE);
                JTxtNomMarc.setText("");
                JTxtNomMarc.requestFocus();
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                JTxtNomMarc.requestFocus();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Campo Vacío", "Error", JOptionPane.ERROR_MESSAGE);
            JTxtNomMarc.requestFocus();
        }
    }//GEN-LAST:event_JBtnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnAceptar;
    private javax.swing.JLabel JLbl1;
    private javax.swing.JLabel JLbl2;
    private javax.swing.JPanel JPanDesk;
    private javax.swing.JTextField JTxtNomMarc;
    // End of variables declaration//GEN-END:variables
}
