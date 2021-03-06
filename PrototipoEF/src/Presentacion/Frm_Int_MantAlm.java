/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class Frm_Int_MantAlm extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_Int_MantAlm
     */
    public Frm_Int_MantAlm() {
        initComponents();
        JBtnAsignar.setVisible(false);
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
        JLbl3 = new javax.swing.JLabel();
        JTxtNomAlm = new javax.swing.JTextField();
        JTxtDirAlm = new javax.swing.JTextField();
        JBtnAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTbData = new javax.swing.JTable();
        JBtnAsignar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Agregar Nuevo Almacén");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Company.png"))); // NOI18N

        JPanDesk.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Almacenes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel", 1, 14))); // NOI18N

        JLbl1.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl1.setText("Agregar nuevo almacen");

        JLbl2.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl2.setText("Nombre Almacen:");

        JLbl3.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl3.setText("Dirección Almacen:");

        JTxtNomAlm.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JTxtDirAlm.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JBtnAceptar.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JBtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Check_16x16.png"))); // NOI18N
        JBtnAceptar.setText("Aceptar");
        JBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnAceptarActionPerformed(evt);
            }
        });

        JTbData.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        JTbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Almacen", "Producto", "Stock Inicial"
            }
        ));
        jScrollPane1.setViewportView(JTbData);

        JBtnAsignar.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JBtnAsignar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Check_16x16.png"))); // NOI18N
        JBtnAsignar.setText("Asignar");
        JBtnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnAsignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanDeskLayout = new javax.swing.GroupLayout(JPanDesk);
        JPanDesk.setLayout(JPanDeskLayout);
        JPanDeskLayout.setHorizontalGroup(
            JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanDeskLayout.createSequentialGroup()
                .addGroup(JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanDeskLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLbl1))
                    .addGroup(JPanDeskLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanDeskLayout.createSequentialGroup()
                                .addGroup(JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLbl2)
                                    .addComponent(JLbl3))
                                .addGap(22, 22, 22)
                                .addGroup(JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTxtNomAlm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTxtDirAlm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(JBtnAceptar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanDeskLayout.createSequentialGroup()
                .addGap(0, 322, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBtnAsignar)
                .addGap(23, 23, 23))
        );
        JPanDeskLayout.setVerticalGroup(
            JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanDeskLayout.createSequentialGroup()
                .addGroup(JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JBtnAsignar)
                    .addGroup(JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(JPanDeskLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(JLbl1)
                            .addGap(67, 67, 67)
                            .addGroup(JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JLbl2)
                                .addComponent(JTxtNomAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(JPanDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JLbl3)
                                .addComponent(JTxtDirAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addComponent(JBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
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
    void llenarStock()
    {
        try
        {
            Object[] modelo = new Object[3];
            DefaultTableModel tModelo = (DefaultTableModel) JTbData.getModel();
            String sql1 = "SELECT codigo_producto FROM producto";
            Conexion con = new Conexion();
            Connection cn = con.getConexion();
            PreparedStatement pst1 = cn.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();
            
            String cod_almacen="";
            String sql2="SELECT Max(id_almacen) FROM almacen";
            PreparedStatement pst2 = cn.prepareStatement(sql2);
            ResultSet rs2 = pst2.executeQuery();
            if(rs2.next()){
                cod_almacen = rs2.getString("Max(id_almacen)");
            }
            while(rs1.next()){
                modelo[0] = cod_almacen;
                modelo[1] = rs1.getString("codigo_producto");
                modelo[2] = "0";
                tModelo.addRow(modelo);
            }
            JTbData.setModel(tModelo);   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    void asignarStock()
    {
        try
        {
            Conexion con = new Conexion();
            Connection cn = con.getConexion();
            if(JTbData.getRowCount()>0){
                for(int i=0; i<JTbData.getRowCount(); i++){
                    PreparedStatement pst3 = cn.prepareStatement("INSERT INTO stock VALUES(?,?,?)");
 
                    pst3.setString(1, (String)JTbData.getValueAt(i, 0));
                    pst3.setString(2, (String)JTbData.getValueAt(i, 1));
                    pst3.setString(3, (String)JTbData.getValueAt(i, 2));
                    pst3.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null, "¡Stock Asignado!");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    boolean verificarTablaProducto()
    {
        try
        {
            Conexion con = new Conexion();
            Connection cn = con.getConexion();
            PreparedStatement ps = cn.prepareStatement("SELECT Count(*) FROM producto");
            int registros=0;
            ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next()){
                registros=rs.getInt(1);
            }
            if(registros>0){
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
            return false;
        }
    }
    
    private void JBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnAceptarActionPerformed
        if(!JTxtNomAlm.getText().equals(""))
        {
            try
            {
                Conexion con = new Conexion();
                Connection cn = con.getConexion();
                PreparedStatement ps = cn.prepareStatement("INSERT INTO almacen VALUES(?,?,?)");
                String nombreAlmacen=JTxtNomAlm.getText();
                String direccionAlmacen = JTxtDirAlm.getText();
                ps.setString(1, "0");
                ps.setString(2, nombreAlmacen);
                ps.setString(3, direccionAlmacen);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Almacén Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);
                
                if(verificarTablaProducto()==true)
                {
                    llenarStock();
                    JBtnAsignar.setVisible(true);
                } 
                else
                {
                    JTxtNomAlm.setText("");
                    JTxtDirAlm.setText("");
                    JTxtNomAlm.requestFocus();
                    DefaultTableModel modelo = (DefaultTableModel) JTbData.getModel();
                    modelo.setRowCount(0);
                    JTbData.setModel(modelo);
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                JTxtNomAlm.requestFocus();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Campo Vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBtnAceptarActionPerformed

    private void JBtnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnAsignarActionPerformed
        asignarStock();
        JTxtNomAlm.setText("");
        JTxtDirAlm.setText("");
        JTxtNomAlm.requestFocus();
        DefaultTableModel modelo = (DefaultTableModel) JTbData.getModel();
        modelo.setRowCount(0);
        JTbData.setModel(modelo);
        JBtnAsignar.setVisible(false);
    }//GEN-LAST:event_JBtnAsignarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnAceptar;
    private javax.swing.JButton JBtnAsignar;
    private javax.swing.JLabel JLbl1;
    private javax.swing.JLabel JLbl2;
    private javax.swing.JLabel JLbl3;
    private javax.swing.JPanel JPanDesk;
    private javax.swing.JTable JTbData;
    private javax.swing.JTextField JTxtDirAlm;
    private javax.swing.JTextField JTxtNomAlm;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
