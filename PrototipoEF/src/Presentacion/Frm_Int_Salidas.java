/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Modelo.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class Frm_Int_Salidas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_Int_Salidas
     */
    public Frm_Int_Salidas() {
        initComponents();
        loadAlmacenes();
        loadProductos();
        clearFilas();
        loadDatos();
    }
    void loadAlmacenes()
    {
        try
        {
            Conexion con = new Conexion();
            Connection cn = con.getConexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre_almacen FROM almacen");
            JCmbAlm.removeAllItems();
            while(rs.next()){
                JCmbAlm.addItem(rs.getString(1));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    void loadProductos()
    {
        try
        {
            Conexion con = new Conexion();
            Connection cn = con.getConexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT codigo_producto FROM producto");
            JCmbProd.removeAllItems();
            while(rs.next()){
                JCmbProd.addItem(rs.getString(1));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    void clearFilas()
    {
       DefaultTableModel Tmodel = (DefaultTableModel) JTbSal.getModel();
       Tmodel.setRowCount(0);
       JTbSal.setModel(Tmodel);
    }
    void loadDatos()
    {
        Object[] modelo = new Object[5];
       DefaultTableModel Tmodel = (DefaultTableModel) JTbSal.getModel();
       try
       {
           Conexion con = new Conexion();
           Connection cn = con.getConexion();
           String sql="SELECT codigo_producto, nombre_almacen, fecha_salida, factura, cantidad_salida FROM salida\n" +
"INNER JOIN almacen ON salida.fk_almacen = almacen.id_almacen\n" +
"INNER JOIN producto ON salida.fk_producto = producto.codigo_producto;";
           PreparedStatement pst = cn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           while(rs.next()){
               modelo[0]=rs.getString("codigo_producto");
               modelo[1]=rs.getString("nombre_almacen");
               modelo[2]=rs.getString("fecha_salida");
               modelo[3]=rs.getString("factura");
               modelo[4]=rs.getString("cantidad_salida");
               Tmodel.addRow(modelo);
           }
           JTbSal.setModel(Tmodel);
       }
       catch(SQLException e)
       {
           JOptionPane.showMessageDialog(null, e.toString());
       }
    }
    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    
    boolean salidaStock(String codigo_producto, String nombre_almacen, int cantidad_salida, String fecha_salida, String factura)
    {
        try
        {
            int id_almacen=0;
            int stock_inicial=0;
            int stock_final=0;
            
            String sql_1 = "SELECT id_almacen FROM almacen WHERE nombre_almacen=?";
            PreparedStatement ps_1 = cn.prepareStatement(sql_1);
            ps_1.setString(1, nombre_almacen);
            ResultSet rs_1 = ps_1.executeQuery();
            if(rs_1.next()){
                id_almacen = rs_1.getInt("id_almacen");
            }
            
            String sql_2 = "SELECT stock_producto FROM Stock WHERE (fk_almacen=? AND fk_producto=?)";
            PreparedStatement ps_2 = cn.prepareStatement(sql_2);
            ps_2.setInt(1, id_almacen);
            ps_2.setString(2, codigo_producto);
            ResultSet rs_2 = ps_2.executeQuery();
            if(rs_2.next()){
                stock_inicial = rs_2.getInt("stock_producto");
            }
            
            if(stock_inicial>=cantidad_salida)
            {
                stock_final = stock_inicial - cantidad_salida;
            
                String sql_3 = "UPDATE stock SET stock_producto=? WHERE (fk_almacen=? AND fk_producto=?)";
                PreparedStatement ps_3 = cn.prepareStatement(sql_3);
                ps_3.setInt(1, stock_final);
                ps_3.setInt(2, id_almacen);
                ps_3.setString(3, codigo_producto);
                ps_3.executeUpdate();

                String sql_4 = "INSERT INTO salida VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement ps_4 = cn.prepareStatement(sql_4);
                ps_4.setString(1, "0");
                ps_4.setString(2, fecha_salida);
                ps_4.setString(3, codigo_producto);
                ps_4.setInt(4, id_almacen);
                ps_4.setInt(5, stock_inicial);
                ps_4.setInt(6, cantidad_salida);
                ps_4.setInt(7, stock_final);
                ps_4.setString(8, factura);
                ps_4.executeUpdate();
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "No Dispone de Stock Suficiente", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
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

        JPanelFrm = new javax.swing.JPanel();
        JLbl1 = new javax.swing.JLabel();
        JLbl2 = new javax.swing.JLabel();
        JLbl3 = new javax.swing.JLabel();
        JLbl4 = new javax.swing.JLabel();
        JLbl5 = new javax.swing.JLabel();
        JCmbProd = new javax.swing.JComboBox<>();
        JCmbAlm = new javax.swing.JComboBox<>();
        JTxtFact = new javax.swing.JTextField();
        JDCFecha = new com.toedter.calendar.JDateChooser();
        JSCant = new javax.swing.JSpinner();
        JBtnAceptar = new javax.swing.JButton();
        JBtnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTbSal = new javax.swing.JTable();
        JLbl6 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Salidas de Inventario");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/shopping_cart_down.png"))); // NOI18N

        JPanelFrm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salidas de Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel", 1, 14))); // NOI18N

        JLbl1.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl1.setText("Producto:");

        JLbl2.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl2.setText("Almacen:");

        JLbl3.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl3.setText("Fecha:");

        JLbl4.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl4.setText("Factura:");

        JLbl5.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl5.setText("Cantidad:");

        JCmbProd.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JCmbAlm.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JTxtFact.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JDCFecha.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JSCant.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JBtnAceptar.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JBtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Check_16x16.png"))); // NOI18N
        JBtnAceptar.setText("Aceptar");
        JBtnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnAceptarActionPerformed(evt);
            }
        });

        JBtnCancelar.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_16x16.png"))); // NOI18N
        JBtnCancelar.setText("Salir");
        JBtnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnCancelarActionPerformed(evt);
            }
        });

        JTbSal.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        JTbSal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Almacen", "Fecha", "Factura", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTbSal);

        JLbl6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        JLbl6.setText("Salidas Realizadas");

        javax.swing.GroupLayout JPanelFrmLayout = new javax.swing.GroupLayout(JPanelFrm);
        JPanelFrm.setLayout(JPanelFrmLayout);
        JPanelFrmLayout.setHorizontalGroup(
            JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelFrmLayout.createSequentialGroup()
                .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelFrmLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLbl1)
                            .addComponent(JLbl2)
                            .addComponent(JLbl4)
                            .addComponent(JLbl3)
                            .addComponent(JLbl5))
                        .addGap(39, 39, 39)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JSCant, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JDCFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                .addComponent(JTxtFact))
                            .addComponent(JCmbAlm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCmbProd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(JPanelFrmLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(JBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLbl6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        JPanelFrmLayout.setVerticalGroup(
            JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelFrmLayout.createSequentialGroup()
                .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelFrmLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLbl1)
                            .addComponent(JCmbProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLbl2)
                            .addComponent(JCmbAlm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLbl3)
                            .addComponent(JDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLbl4)
                            .addComponent(JTxtFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLbl5)
                            .addComponent(JSCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPanelFrmLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(JLbl6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanelFrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanelFrm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBtnCancelarActionPerformed

    private void JBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnAceptarActionPerformed
        try
        {
            String codigo_producto, nombre_almacen;
            int cantidad_salida;
            
            codigo_producto = JCmbProd.getSelectedItem().toString();
            nombre_almacen = JCmbAlm.getSelectedItem().toString();
            cantidad_salida = (int)JSCant.getValue();
            Date fecha_salida = JDCFecha.getDate();
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            String factura = JTxtFact.getText();
            
            if(salidaStock(codigo_producto, nombre_almacen, cantidad_salida, dt1.format(fecha_salida),factura)==true)
            {
                JOptionPane.showMessageDialog(null, "Salida Realizada", "Información", JOptionPane.INFORMATION_MESSAGE);
                clearFilas();
                loadDatos();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Salida No Realizada", "Error", JOptionPane.ERROR_MESSAGE);
                clearFilas();
                loadDatos();
            }
        }
        catch(HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBtnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnAceptar;
    private javax.swing.JButton JBtnCancelar;
    private javax.swing.JComboBox<String> JCmbAlm;
    private javax.swing.JComboBox<String> JCmbProd;
    private com.toedter.calendar.JDateChooser JDCFecha;
    private javax.swing.JLabel JLbl1;
    private javax.swing.JLabel JLbl2;
    private javax.swing.JLabel JLbl3;
    private javax.swing.JLabel JLbl4;
    private javax.swing.JLabel JLbl5;
    private javax.swing.JLabel JLbl6;
    private javax.swing.JPanel JPanelFrm;
    private javax.swing.JSpinner JSCant;
    private javax.swing.JTable JTbSal;
    private javax.swing.JTextField JTxtFact;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
