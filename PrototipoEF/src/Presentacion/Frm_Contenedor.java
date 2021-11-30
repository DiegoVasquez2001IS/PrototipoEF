/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Modelo.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Frm_Contenedor extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Contenedor
     */
    public Frm_Contenedor() {
        initComponents();
    }
    Usuario mod;
    Frm_Contenedor(Usuario mod) {
        initComponents();
        this.mod = mod;

        if (mod.getId_Tipo() == 1) 
        {
            JMenuOp.setVisible(true);
            JMenuMant.setVisible(true);
        } 
        else if(mod.getId_Tipo() == 2){
            JMenuMant.setVisible(false);
        }
        else 
        {
            JMenuOp.setVisible(false);
            JMenuMant.setVisible(false);
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

        JDeskPaneSys = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuArch = new javax.swing.JMenu();
        JItemSalir = new javax.swing.JMenuItem();
        JMenuOp = new javax.swing.JMenu();
        JItemEntradas = new javax.swing.JMenuItem();
        JItemSalidas = new javax.swing.JMenuItem();
        JItemTraslados = new javax.swing.JMenuItem();
        JMenuMant = new javax.swing.JMenu();
        JItemCat = new javax.swing.JMenuItem();
        JItemMarc = new javax.swing.JMenuItem();
        JItemAlm = new javax.swing.JMenuItem();
        JItemProd = new javax.swing.JMenuItem();
        JItemUsu = new javax.swing.JMenuItem();
        JMenuRepo = new javax.swing.JMenu();
        JMenuStock = new javax.swing.JMenu();
        ItemStP = new javax.swing.JMenuItem();
        ItemStA = new javax.swing.JMenuItem();
        JMenuAyuda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instalaser");
        setResizable(false);

        javax.swing.GroupLayout JDeskPaneSysLayout = new javax.swing.GroupLayout(JDeskPaneSys);
        JDeskPaneSys.setLayout(JDeskPaneSysLayout);
        JDeskPaneSysLayout.setHorizontalGroup(
            JDeskPaneSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        JDeskPaneSysLayout.setVerticalGroup(
            JDeskPaneSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );

        JMenuArch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/folder16p.png"))); // NOI18N
        JMenuArch.setText("Archivo");
        JMenuArch.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JItemSalir.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Log Out_16x16.png"))); // NOI18N
        JItemSalir.setText("Salir del Sistema");
        JItemSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JItemSalirActionPerformed(evt);
            }
        });
        JMenuArch.add(JItemSalir);

        jMenuBar1.add(JMenuArch);

        JMenuOp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/process16p.png"))); // NOI18N
        JMenuOp.setText("Operaciones de Inventario");
        JMenuOp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JMenuOp.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JItemEntradas.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JItemEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/shopping_cart_up.png"))); // NOI18N
        JItemEntradas.setText("Entradas");
        JItemEntradas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JItemEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JItemEntradasActionPerformed(evt);
            }
        });
        JMenuOp.add(JItemEntradas);

        JItemSalidas.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JItemSalidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/shopping_cart_down.png"))); // NOI18N
        JItemSalidas.setText("Salidas");
        JItemSalidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JItemSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JItemSalidasActionPerformed(evt);
            }
        });
        JMenuOp.add(JItemSalidas);

        JItemTraslados.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JItemTraslados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Redo_16x16.png"))); // NOI18N
        JItemTraslados.setText("Traslados");
        JItemTraslados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JItemTraslados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JItemTrasladosActionPerformed(evt);
            }
        });
        JMenuOp.add(JItemTraslados);

        jMenuBar1.add(JMenuOp);

        JMenuMant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/page_edit16p.png"))); // NOI18N
        JMenuMant.setText("Mantenimientos del Sistema");
        JMenuMant.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JItemCat.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JItemCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Green tag.png"))); // NOI18N
        JItemCat.setText("Categorías");
        JItemCat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JItemCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JItemCatActionPerformed(evt);
            }
        });
        JMenuMant.add(JItemCat);

        JItemMarc.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JItemMarc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Script.png"))); // NOI18N
        JItemMarc.setText("Marcas");
        JItemMarc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JItemMarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JItemMarcActionPerformed(evt);
            }
        });
        JMenuMant.add(JItemMarc);

        JItemAlm.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JItemAlm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Company.png"))); // NOI18N
        JItemAlm.setText("Almacenes");
        JItemAlm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JItemAlm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JItemAlmActionPerformed(evt);
            }
        });
        JMenuMant.add(JItemAlm);

        JItemProd.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JItemProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Database.png"))); // NOI18N
        JItemProd.setText("Productos");
        JItemProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JItemProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JItemProdActionPerformed(evt);
            }
        });
        JMenuMant.add(JItemProd);

        JItemUsu.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        JItemUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/User_16x16.png"))); // NOI18N
        JItemUsu.setText("Usuarios");
        JItemUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JItemUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JItemUsuActionPerformed(evt);
            }
        });
        JMenuMant.add(JItemUsu);

        jMenuBar1.add(JMenuMant);

        JMenuRepo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/chart16p.png"))); // NOI18N
        JMenuRepo.setText("Reportes de Inventario");
        JMenuRepo.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        JMenuStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Report.png"))); // NOI18N
        JMenuStock.setText("Stock");
        JMenuStock.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        ItemStP.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        ItemStP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Report.png"))); // NOI18N
        ItemStP.setText("Por Producto");
        ItemStP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemStPActionPerformed(evt);
            }
        });
        JMenuStock.add(ItemStP);

        ItemStA.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        ItemStA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Report.png"))); // NOI18N
        ItemStA.setText("Por Almacen");
        ItemStA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemStAActionPerformed(evt);
            }
        });
        JMenuStock.add(ItemStA);

        JMenuRepo.add(JMenuStock);

        jMenuBar1.add(JMenuRepo);

        JMenuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/help16p.png"))); // NOI18N
        JMenuAyuda.setText("Ayuda");
        JMenuAyuda.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/help16p.png"))); // NOI18N
        jMenuItem1.setText("Acerca de");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JMenuAyuda.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/User_16x16.png"))); // NOI18N
        jMenuItem2.setText("Soporte");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        JMenuAyuda.add(jMenuItem2);

        jMenuBar1.add(JMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JDeskPaneSys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDeskPaneSys, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JItemSalirActionPerformed
        int i_resp = JOptionPane.showConfirmDialog(null, "¿Desea Salir del Sistema?","", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(i_resp==0)
        {
            this.dispose();
            Frm_Inicio frmInicio = new Frm_Inicio();
            frmInicio.setVisible(true);
        }
    }//GEN-LAST:event_JItemSalirActionPerformed

    private void JItemEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JItemEntradasActionPerformed
        Frm_Int_Entradas frmIntEntradas = new Frm_Int_Entradas();
        frmIntEntradas.setVisible(true);
        JDeskPaneSys.add(frmIntEntradas);
    }//GEN-LAST:event_JItemEntradasActionPerformed

    private void JItemSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JItemSalidasActionPerformed
        Frm_Int_Salidas frmIntSalidas = new Frm_Int_Salidas();
        frmIntSalidas.setVisible(true);
        JDeskPaneSys.add(frmIntSalidas);
    }//GEN-LAST:event_JItemSalidasActionPerformed

    private void JItemTrasladosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JItemTrasladosActionPerformed
        Frm_Int_Tras frmIntTraslados = new Frm_Int_Tras();
        frmIntTraslados.setVisible(true);
        JDeskPaneSys.add(frmIntTraslados);
    }//GEN-LAST:event_JItemTrasladosActionPerformed

    private void JItemUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JItemUsuActionPerformed
        Frm_Registro frmRegistro = new Frm_Registro();
        frmRegistro.setVisible(true);
    }//GEN-LAST:event_JItemUsuActionPerformed

    private void JItemCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JItemCatActionPerformed
        Frm_Int_MantCat frmIntMantCat = new Frm_Int_MantCat();
        frmIntMantCat.setVisible(true);
        JDeskPaneSys.add(frmIntMantCat);
    }//GEN-LAST:event_JItemCatActionPerformed

    private void JItemMarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JItemMarcActionPerformed
        Frm_Int_MantMarc frmIntMantMarc = new Frm_Int_MantMarc();
        frmIntMantMarc.setVisible(true);
        JDeskPaneSys.add(frmIntMantMarc);
    }//GEN-LAST:event_JItemMarcActionPerformed

    private void JItemAlmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JItemAlmActionPerformed
        Frm_Int_MantAlm frmIntMantAlm = new Frm_Int_MantAlm();
        frmIntMantAlm.setVisible(true);
        JDeskPaneSys.add(frmIntMantAlm);
    }//GEN-LAST:event_JItemAlmActionPerformed

    private void JItemProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JItemProdActionPerformed
        Frm_Int_MantProd frmIntMantProd = new Frm_Int_MantProd();
        frmIntMantProd.setVisible(true);
        JDeskPaneSys.add(frmIntMantProd);
    }//GEN-LAST:event_JItemProdActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(null, "Versión RC [Release Candidate]. Es una versión previa al lanzamiento oficial", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(null, "Para soporte con la aplicación o base de datos contactarse con el desarrollador: Diego Vásquez (+502 58155771, diegovasqezis2018@gmail.com)", "Soporte", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ItemStPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemStPActionPerformed
        Frm_StockP frmStockP = new Frm_StockP();
        frmStockP.setVisible(true);
        JDeskPaneSys.add(frmStockP);
    }//GEN-LAST:event_ItemStPActionPerformed

    private void ItemStAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemStAActionPerformed
        Frm_StockAlm frmStockA = new Frm_StockAlm();
        frmStockA.setVisible(true);
        JDeskPaneSys.add(frmStockA);
    }//GEN-LAST:event_ItemStAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Contenedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Contenedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemStA;
    private javax.swing.JMenuItem ItemStP;
    private javax.swing.JDesktopPane JDeskPaneSys;
    private javax.swing.JMenuItem JItemAlm;
    private javax.swing.JMenuItem JItemCat;
    private javax.swing.JMenuItem JItemEntradas;
    private javax.swing.JMenuItem JItemMarc;
    private javax.swing.JMenuItem JItemProd;
    private javax.swing.JMenuItem JItemSalidas;
    private javax.swing.JMenuItem JItemSalir;
    private javax.swing.JMenuItem JItemTraslados;
    private javax.swing.JMenuItem JItemUsu;
    private javax.swing.JMenu JMenuArch;
    private javax.swing.JMenu JMenuAyuda;
    private javax.swing.JMenu JMenuMant;
    private javax.swing.JMenu JMenuOp;
    private javax.swing.JMenu JMenuRepo;
    private javax.swing.JMenu JMenuStock;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}