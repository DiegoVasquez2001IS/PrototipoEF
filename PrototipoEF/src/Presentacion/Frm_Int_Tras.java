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
public class Frm_Int_Tras extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_Int_Tras
     */
    public Frm_Int_Tras() {
        initComponents();
        loadAlmacenes();
        loadProductos();
        clearFilas();
        loadDatos1();
        loadDatos2();
    }
    void loadAlmacenes()
    {
        try
        {
            Conexion con = new Conexion();
            Connection cn = con.getConexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre_almacen FROM almacen");
            JCmbOrigen.removeAllItems();
            JCmbDestino.removeAllItems();
            while(rs.next()){
                JCmbOrigen.addItem(rs.getString(1));
                JCmbDestino.addItem(rs.getString(1));
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
            JCmbProducto.removeAllItems();
            while(rs.next()){
                JCmbProducto.addItem(rs.getString(1));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    void clearFilas()
    {
       DefaultTableModel Tmodel1 = (DefaultTableModel) JTBTras1.getModel();
       Tmodel1.setRowCount(0);
       JTBTras1.setModel(Tmodel1);
       DefaultTableModel Tmodel2 = (DefaultTableModel) JTbD.getModel();
       Tmodel2.setRowCount(0);
       JTbD.setModel(Tmodel2);
    }
    void loadDatos1()
    {
        Object[] modelo1 = new Object[6];
        DefaultTableModel Tmodel1 = (DefaultTableModel) JTBTras1.getModel();
       try
       {
           Conexion con = new Conexion();
           Connection cn = con.getConexion();
           String sql1="select fecha_traslado, nombre_almacen, fk_producto, stock_inicial, cantidad_traslado, stock_final from traslado_origen\n" +
"inner join traslado on traslado_origen.fk_traslado = traslado.id_traslado\n" +
"inner join almacen on traslado_origen.fk_almacenOrigen = almacen.id_almacen";
           PreparedStatement pst1 = cn.prepareStatement(sql1);
           ResultSet rs1 = pst1.executeQuery();
           while(rs1.next()){
               modelo1[0]=rs1.getString("fecha_traslado");
               modelo1[1]=rs1.getString("nombre_almacen");
               modelo1[2]=rs1.getString("fk_producto");
               modelo1[3]=rs1.getString("stock_inicial");
               modelo1[4]=rs1.getString("cantidad_traslado");
               modelo1[5]=rs1.getString("stock_final");
               Tmodel1.addRow(modelo1);
           }
           JTBTras1.setModel(Tmodel1);
       }
       catch(SQLException e)
       {
           JOptionPane.showMessageDialog(null, e.toString());
       }
    }
    
    void loadDatos2()
    {
        Object[] modelo2 = new Object[6];
        DefaultTableModel Tmodel2 = (DefaultTableModel) JTbD.getModel();
       try
       {
           Conexion con = new Conexion();
           Connection cn = con.getConexion();
           String sql1="select fecha_traslado, nombre_almacen, fk_producto, stock_inicial, cantidad_traslado, stock_final from traslado_destino\n" +
"inner join traslado on traslado_destino.fk_traslado = traslado.id_traslado\n" +
"inner join almacen on traslado_destino.fk_almacenDestino = almacen.id_almacen";
           PreparedStatement pst1 = cn.prepareStatement(sql1);
           ResultSet rs1 = pst1.executeQuery();
           while(rs1.next()){
               modelo2[0]=rs1.getString("fecha_traslado");
               modelo2[1]=rs1.getString("nombre_almacen");
               modelo2[2]=rs1.getString("fk_producto");
               modelo2[3]=rs1.getString("stock_inicial");
               modelo2[4]=rs1.getString("cantidad_traslado");
               modelo2[5]=rs1.getString("stock_final");
               Tmodel2.addRow(modelo2);
           }
           JTbD.setModel(Tmodel2);
       }
       catch(SQLException e)
       {
           JOptionPane.showMessageDialog(null, e.toString());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBTras1 = new javax.swing.JTable();
        JDCFecha = new com.toedter.calendar.JDateChooser();
        JCmbOrigen = new javax.swing.JComboBox<>();
        JCmbDestino = new javax.swing.JComboBox<>();
        JCmbProducto = new javax.swing.JComboBox<>();
        JSCant = new javax.swing.JSpinner();
        JLbl6 = new javax.swing.JLabel();
        JBtnAceptar = new javax.swing.JButton();
        JBtnCancelar = new javax.swing.JButton();
        JLbl7 = new javax.swing.JLabel();
        JLbl8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTbD = new javax.swing.JTable();

        setClosable(true);
        setTitle("Traslados de Productos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Redo_16x16.png"))); // NOI18N

        JPanelFrm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Traslados de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel", 1, 14))); // NOI18N

        JLbl1.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl1.setText("Fecha Traslado:");

        JLbl2.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl2.setText("Almacén Orígen:");

        JLbl3.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl3.setText("Almacén Destino:");

        JLbl4.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl4.setText("Producto:");

        JLbl5.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JLbl5.setText("Cantidad:");

        JTBTras1.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        JTBTras1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Almacén Orígen", "Producto", "Stock Anterior", "Cantidad", "Nuevo Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTBTras1);

        JDCFecha.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JCmbOrigen.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JCmbDestino.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JCmbProducto.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JSCant.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JLbl6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        JLbl6.setText("Traslados Realizados");

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

        JLbl7.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        JLbl7.setText("Orígen");

        JLbl8.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        JLbl8.setText("Destino");

        JTbD.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JTbD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Almacén Destino", "Producto", "Stock Anterior", "Cantidad", "Nuevo Stock"
            }
        ));
        jScrollPane3.setViewportView(JTbD);

        javax.swing.GroupLayout JPanelFrmLayout = new javax.swing.GroupLayout(JPanelFrm);
        JPanelFrm.setLayout(JPanelFrmLayout);
        JPanelFrmLayout.setHorizontalGroup(
            JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelFrmLayout.createSequentialGroup()
                .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelFrmLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLbl1)
                            .addComponent(JLbl2)
                            .addComponent(JLbl3)
                            .addComponent(JLbl4)
                            .addComponent(JLbl5))
                        .addGap(59, 59, 59)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JCmbOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JCmbDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JCmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JSCant, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPanelFrmLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(JBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLbl6)
                    .addGroup(JPanelFrmLayout.createSequentialGroup()
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLbl7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLbl8)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelFrmLayout.setVerticalGroup(
            JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelFrmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLbl6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLbl7)
                    .addComponent(JLbl8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addGroup(JPanelFrmLayout.createSequentialGroup()
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLbl1)
                            .addComponent(JDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLbl2)
                            .addComponent(JCmbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLbl3)
                            .addComponent(JCmbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLbl4)
                            .addComponent(JCmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLbl5)
                            .addComponent(JSCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(JPanelFrmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(138, 138, 138))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanelFrm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanelFrm, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Conexion con = new Conexion();
    Connection cn = con.getConexion();
    
    boolean trasladoInventario(String fecha_traslado, String codigo_producto, String almacen_origen, String almacen_destino, int cantidad_traslado)
    {
        try
        {
            int stock_origen_inicial=0;
            int stock_destino_inicial=0;
            int stock_origen_final=0;
            int stock_destino_final=0;
            int id_origen=0;
            int id_destino=0;
            
            String sql_1 = "SELECT id_almacen FROM almacen WHERE nombre_almacen=?";
            PreparedStatement ps_1 = cn.prepareStatement(sql_1);
            ps_1.setString(1, almacen_origen);
            ResultSet rs_1 = ps_1.executeQuery();
            if(rs_1.next())
            {
                id_origen = rs_1.getInt("id_almacen");
            }
            
            String sql_2 = "SELECT id_almacen FROM almacen WHERE nombre_almacen=?";
            PreparedStatement ps_2 = cn.prepareStatement(sql_2);
            ps_2.setString(1, almacen_destino);
            ResultSet rs_2 = ps_2.executeQuery();
            if(rs_2.next())
            {
                id_destino = rs_2.getInt("id_almacen");
            }
            
            String sql_3 = "SELECT stock_producto FROM stock WHERE (fk_almacen=? AND fk_producto=?)";
            PreparedStatement ps_3 = cn.prepareStatement(sql_3);
            ps_3.setInt(1, id_origen);
            ps_3.setString(2, codigo_producto);
            ResultSet rs_3 = ps_3.executeQuery();
            if(rs_3.next())
            {
                stock_origen_inicial = rs_3.getInt("stock_producto");
            }
            
            String sql_4 = "SELECT stock_producto FROM stock WHERE (fk_almacen=? AND fk_producto=?)";
            PreparedStatement ps_4 = cn.prepareStatement(sql_4);
            ps_4.setInt(1, id_destino);
            ps_4.setString(2, codigo_producto);
            ResultSet rs_4 = ps_4.executeQuery();
            if(rs_4.next())
            {
                stock_destino_inicial = rs_4.getInt("stock_producto");
            }
            
            if(stock_origen_inicial>=cantidad_traslado)
            {
                stock_origen_final = stock_origen_inicial - cantidad_traslado;
                stock_destino_final = stock_destino_inicial + cantidad_traslado;
                
                String sql_ins = "INSERT INTO traslado VALUES(?,?)";
                PreparedStatement ps_i = cn.prepareStatement(sql_ins);
                ps_i.setString(1, "0");
                ps_i.setString(2, fecha_traslado);
                ps_i.executeUpdate();
                
                int id_traslado=0;
                String sql_getId = "SELECT Max(id_traslado) FROM traslado";
                PreparedStatement ps_getId = cn.prepareStatement(sql_getId);
                ResultSet rs_getId = ps_getId.executeQuery();
                if(rs_getId.next())
                {
                    id_traslado = rs_getId.getInt("Max(id_traslado)");
                }
                String sql_5 = "UPDATE stock SET stock_producto=? WHERE (fk_almacen=? AND fk_producto=?)";
                PreparedStatement ps_5 = cn.prepareStatement(sql_5);
                ps_5.setInt(1, stock_origen_final);
                ps_5.setInt(2, id_origen);
                ps_5.setString(3, codigo_producto);
                ps_5.executeUpdate();
                
                String sql_6 = "UPDATE stock SET stock_producto=? WHERE (fk_almacen=? AND fk_producto=?)";
                PreparedStatement ps_6 = cn.prepareStatement(sql_6);
                ps_6.setInt(1, stock_destino_final);
                ps_6.setInt(2, id_destino);
                ps_6.setString(3, codigo_producto);
                ps_6.executeUpdate();
                
                String sql_7 = "INSERT INTO traslado_origen VALUES (?,?,?,?,?,?,?)";
                PreparedStatement ps_7 = cn.prepareStatement(sql_7);
                ps_7.setString(1, "0");
                ps_7.setInt(2, id_origen);
                ps_7.setString(3, codigo_producto);
                ps_7.setInt(4, id_traslado);
                ps_7.setInt(5, stock_origen_inicial);
                ps_7.setInt(6, cantidad_traslado);
                ps_7.setInt(7, stock_origen_final);
                ps_7.executeUpdate();
                
                String sql_8 = "INSERT INTO traslado_destino VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps_8 = cn.prepareStatement(sql_8);
                ps_8.setString(1, "0");
                ps_8.setInt(2, id_destino);
                ps_8.setString(3, codigo_producto);
                ps_8.setInt(4, id_traslado);
                ps_8.setInt(5, stock_destino_inicial);
                ps_8.setInt(6, cantidad_traslado);
                ps_8.setInt(7, stock_destino_final);
                ps_8.executeUpdate();
                
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Cantidad Solicitada Mayor al Stock Disponible", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    private void JBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnAceptarActionPerformed
        if(!JCmbDestino.getSelectedItem().equals(JCmbOrigen.getSelectedItem()))
        {
            if((int)JSCant.getValue()>0){
                Date fecha_traslado = JDCFecha.getDate();
                SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
                String cod_prod = JCmbProducto.getSelectedItem().toString();
                String origen = JCmbOrigen.getSelectedItem().toString();
                String destino = JCmbDestino.getSelectedItem().toString();
                int cantidad_traslado = (int)JSCant.getValue();

                if(trasladoInventario(dt1.format(fecha_traslado), cod_prod, origen, destino, cantidad_traslado)==true)
                {
                    JOptionPane.showMessageDialog(null, "Traslado Realizado", "Información", JOptionPane.INFORMATION_MESSAGE);
                    clearFilas();
                    loadDatos1();
                    loadDatos2();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Traslado No Realizado", "Error", JOptionPane.ERROR_MESSAGE);
                    clearFilas();
                    loadDatos1();
                    loadDatos2();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Cantidad no valida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se puede trasladar un prouducto al mismo destino, verifique el destino", "Error", JOptionPane.ERROR_MESSAGE);
            clearFilas();
            loadDatos1();
            loadDatos2();
        }
    }//GEN-LAST:event_JBtnAceptarActionPerformed
    
    private void JBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnCancelarActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_JBtnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnAceptar;
    private javax.swing.JButton JBtnCancelar;
    private javax.swing.JComboBox<String> JCmbDestino;
    private javax.swing.JComboBox<String> JCmbOrigen;
    private javax.swing.JComboBox<String> JCmbProducto;
    private com.toedter.calendar.JDateChooser JDCFecha;
    private javax.swing.JLabel JLbl1;
    private javax.swing.JLabel JLbl2;
    private javax.swing.JLabel JLbl3;
    private javax.swing.JLabel JLbl4;
    private javax.swing.JLabel JLbl5;
    private javax.swing.JLabel JLbl6;
    private javax.swing.JLabel JLbl7;
    private javax.swing.JLabel JLbl8;
    private javax.swing.JPanel JPanelFrm;
    private javax.swing.JSpinner JSCant;
    private javax.swing.JTable JTBTras1;
    private javax.swing.JTable JTbD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
